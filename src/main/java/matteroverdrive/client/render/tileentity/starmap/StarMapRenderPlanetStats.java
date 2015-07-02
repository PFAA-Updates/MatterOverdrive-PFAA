package matteroverdrive.client.render.tileentity.starmap;

import cofh.lib.gui.GuiColor;
import matteroverdrive.Reference;
import matteroverdrive.api.starmap.IShip;
import matteroverdrive.proxy.ClientProxy;
import matteroverdrive.starmap.data.Galaxy;
import matteroverdrive.starmap.data.Planet;
import matteroverdrive.starmap.data.SpaceBody;
import matteroverdrive.tile.TileEntityMachineStarMap;
import matteroverdrive.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Simeon on 7/2/2015.
 */
public class StarMapRenderPlanetStats extends StarMapRendererPlanet
{
    @Override
    public void renderBody(Galaxy galaxy, SpaceBody spaceBody, TileEntityMachineStarMap starMap, float partialTicks, float viewerDistance) {
        if (spaceBody instanceof Planet) {

            Planet to = (Planet) spaceBody;
            Planet from = galaxy.getPlanet(starMap.getGalaxyPosition());

            if (from != null && from != to) {
                glPushMatrix();
                glRotated(Minecraft.getMinecraft().renderViewEntity.rotationYaw, 0, -1, 0);
                glEnable(GL_BLEND);
                glPushMatrix();
                glTranslated((getClampedSize(to) + 0.25), 0, 0);
                renderPlanet(from, viewerDistance);
                glPopMatrix();

                glPushMatrix();
                glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
                glEnable(GL_TEXTURE_2D);
                glEnable(GL_ALPHA_TEST);
                glScaled(0.01, 0.01, 0.01);
                glRotated(180, 0, 0, 1);
                glTranslated(-9, -9, 0);
                ClientProxy.holoIcons.renderIcon("arrow_right", 0, 0);
                glPopMatrix();

                glEnable(GL_BLEND);
                glBlendFunc(GL_ONE, GL_ONE);
                glPushMatrix();
                glTranslated(-(getClampedSize(from) + 0.25), 0, 0);
                renderPlanet(to, viewerDistance);
                glPopMatrix();
                glPopMatrix();
            }else
            {
                glEnable(GL_BLEND);
                glBlendFunc(GL_ONE, GL_ONE);
                glPushMatrix();
                renderPlanet(to, viewerDistance);
                glPopMatrix();
            }

            glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            glEnable(GL_TEXTURE_2D);
        }
    }

    @Override
    protected void drawPlanetInfoClose(Planet planet)
    {

    }

    @Override
    public void renderGUIInfo(Galaxy galaxy, SpaceBody spaceBody,TileEntityMachineStarMap starMap, float partialTicks, float opacity)
    {
        if (spaceBody instanceof Planet)
        {
            Planet planet = (Planet)spaceBody;
            int y = 0;
            for (ItemStack shipStack : planet.getFleet())
            {
                if (shipStack.getItem() instanceof IShip)
                {
                    IShip ship = (IShip)shipStack.getItem();
                    GuiColor shipColor = Reference.COLOR_HOLO;
                    if (!ship.isOwner(shipStack, Minecraft.getMinecraft().thePlayer))
                    {
                        shipColor = Reference.COLOR_HOLO_RED;
                    }

                    RenderUtils.renderStack(16,y-16,shipStack);
                    fontRenderer.drawString(shipStack.getDisplayName(),36,y-10, shipColor.getColor());
                    y -= 16;
                }
            }
        }
    }

    @Override
    protected float getClampedSize(Planet planet)
    {
        return Math.min(Math.max(planet.getSize(),1f),2.2f) * 0.3f;
    }
}
