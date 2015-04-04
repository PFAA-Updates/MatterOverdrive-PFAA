package com.MO.MatterOverdrive.gui;

import java.util.ArrayList;
import java.util.List;

import cofh.lib.gui.element.ElementBase;
import com.MO.MatterOverdrive.MatterOverdrive;
import com.MO.MatterOverdrive.api.matter.IMatterDatabase;
import com.MO.MatterOverdrive.gui.element.*;
import com.MO.MatterOverdrive.gui.pages.PageInfo;
import com.MO.MatterOverdrive.gui.pages.PageScanInfo;
import com.MO.MatterOverdrive.items.MatterScanner;
import com.MO.MatterOverdrive.network.packet.PacketMatterScannerUpdate;

import cofh.lib.gui.GuiColor;
import cofh.lib.gui.container.ContainerFalse;
import cofh.lib.gui.element.ElementButton;

import com.MO.MatterOverdrive.Reference;
import com.MO.MatterOverdrive.util.MatterDatabaseHelper;
import com.MO.MatterOverdrive.util.MatterHelper;
import com.MO.MatterOverdrive.util.RenderUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiMatterScanner extends MOGuiBase
{
	public ItemStack scanner;
    public int databaseSlot;
	public static boolean panelOpen;

	private static final String INFO_PAGE_BUTTON_NAME = "InfoPageButton";
	private static final String SCAN_PAGE_BUTTON_NAME = "ScanPageButton";
	public static final String QUIDE_ELEMENTS_NAME = "QuideList";

	public static final ResourceLocation background = new ResourceLocation(Reference.PATH_GUI + "matter_scanner.png");
	public static final String backgroundPath = Reference.PATH_GUI + "matter_scanner.png";

	int lastPage;
	PageScanInfo pageScanInfo;
	PageInfo pageInfo;

	NBTTagCompound lastSelected;

	ElementButton infoPageButton;
	ElementButton scanPageButton;
	
	int xStart = 0,yStart = 0;

	public GuiMatterScanner(ItemStack scanner,int slot)
	{
		super(new ContainerFalse());
		this.scanner = scanner;
		//this.texture = background;
		//this.xSize = 216;
		//this.ySize = 176;

		this.databaseSlot = slot;
		lastSelected = MatterScanner.getSelectedAsNBT(scanner);
		lastPage = MatterScanner.getLastPage(scanner);

		pageScanInfo = new PageScanInfo(this,0,0,"Scan Process",lastSelected,scanner);
		pageScanInfo.setSize(this.xSize, this.ySize);
		pageInfo = new PageInfo(this,0,0,"Matter Overdrive");
		pageInfo.setSize(this.xSize,this.ySize);

		scanPageButton = new ElementButton(this,sidePannel.getPosX() + 6,sidePannel.getPosY() + 8,SCAN_PAGE_BUTTON_NAME,0,0,22,0,22,0,22,22,"");
		scanPageButton.setTexture(Reference.PATH_GUI_ITEM + "search54.png", 44, 22);
		infoPageButton = new ElementButton(this,sidePannel.getPosX() + 6,sidePannel.getPosY() + 28 + 8,INFO_PAGE_BUTTON_NAME,0,0,22,0,22,0,22,22,"");
		infoPageButton.setTexture(Reference.PATH_GUI_ITEM + "info20.png", 44, 22);
	}
	
	@Override
	public void initGui() 
	{
		super.initGui();

		//set selected item in list, as active object
		if(pageScanInfo.list.getSelectedElement() != null)
			SetSelected((NBTTagCompound) pageScanInfo.list.getSelectedElement().getValue());

		this.addElement(scanPageButton);
		this.addElement(infoPageButton);
		this.addElement(pageScanInfo);
		this.addElement(pageInfo);

		if(scanner.hasTagCompound()) {
			setPage(scanner.getTagCompound().getByte(MatterScanner.PAGE_TAG_NAME));
			setPanelOpen(panelOpen);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {

		drawElements(0, true);
		drawTabs(0, true);
	}

	@Override
	public void OnPanelOpen(boolean isOpen)
	{
		infoPageButton.setVisible(isOpen);
		scanPageButton.setVisible(isOpen);
		panelOpen = isOpen;
	}

	@Override
	public void handleElementButtonClick(String buttonName, int mouseButton) 
	{
		super.handleElementButtonClick(buttonName, mouseButton);

		if(buttonName == PageScanInfo.SCROLL_UP_BUTTON_NAME)
		{
			pageScanInfo.list.scrollUp();
		}
		else if(buttonName == PageScanInfo.SCROLL_DOWN_BUTTON_NAME)
		{
			pageScanInfo.list.scrollDown();
		}
		else if (buttonName == PageScanInfo.LIST_ELEMENT_NAME)
		{
			NBTTagCompound elementTag = (NBTTagCompound)pageScanInfo.list.getElement(mouseButton).getValue();
			SetSelected(elementTag);
		}
		else if(buttonName == INFO_PAGE_BUTTON_NAME)
		{
			setPage(1);
		}
		else if(buttonName == SCAN_PAGE_BUTTON_NAME)
		{
			setPage(0);
		}
	}

	@Override
	public void handleListChange(String listName, int mouseButton,int element)
	{
		if(listName == QUIDE_ELEMENTS_NAME)
		{
			pageInfo.OpenQuide(element);
		}
	}

	void setPage(int page)
	{
		if(scanner.hasTagCompound())
		{
			scanner.getTagCompound().setShort(MatterScanner.PAGE_TAG_NAME, (short) page);
		}

		//pages
		pageScanInfo.setVisible(false);
		pageInfo.setVisible(false);

		//buttons
		scanPageButton.setEnabled(true);
		infoPageButton.setEnabled(true);

		lastPage = page;

		if(page == 0)
		{
			scanPageButton.setEnabled(false);
			pageScanInfo.setVisible(true);
		}
		else
		{
			infoPageButton.setEnabled(false);
			pageInfo.setVisible(true);
		}
	}

	void SetSelected(NBTTagCompound tagCompound)
	{
		if(tagCompound != null)
		{
			lastSelected = tagCompound;
			pageScanInfo.setItemNBT(tagCompound);
		}
	}

    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();
        if(MatterDatabaseHelper.areEqual(MatterScanner.getSelectedAsNBT(scanner),lastSelected))
            MatterOverdrive.packetPipeline.sendToServer(new PacketMatterScannerUpdate(scanner, (short) databaseSlot));
    }
}