#### 0.4.6-PFAA

* Adjust damage values for Android MOd to work with TFC
* Adjust base damage for the Plasma Shotgun, Phaser, OmniTool and ion sniper to work with TFC
* Create project changlog with previous changes for prior releases pulled from curse

#### 0.4.5

* Fix for config file name being invalid. Fix for android mob whitelist adding to blacklist.

#### 0.4.3

* First community release of 1.7.10

#### 0.4.2-Hotfix 1

* Updated Matter Overdrive Website URL

#### 0.4.2

* Minor bugfixes

#### 0.4.1-Hotfix 1

* Fixed G.M.O. quest crash
* Fixed Google Analytics crashing on dedicated servers
* Added Google Analytics to Quests

#### 0.4.1

* Matter Registry now uses Item Registry names instead of unlocalized names.
* TConstruct integration
* New tritanium tools
* Fixed machine dismantling duplication
* Android glitching can now be disabled in config
* Weapon system overhaul
  * Damage balancing
  * New Screen effects
  * New Weapon attributes
  * Lag compensation for plasma bolts
  * Weapons now affected by player attack damage
  * New random legendary weapons dropped from Legendary rogue androids
* New Molecular Inscriber machine
* New Tritanium Crate storage
* Added recipes for decorative blocks as well as new rotated versions
* New tritanium armor with a custom model
* New ranged rogue androids
  * Android can now use energy weapons
* Level system for rogue androids
  * 3 tiers of rogue androids with scaling stats
* Legendary rogue androids that drop random Legendary parts and weapons
* New World Generation (from images)
  * Crash Space ship (anywhere)
  * Cargo Ship (anywhere in the sky)
  * Sand Pit (desert)
  * Underwater base (ocean)
  * Android house (anywhere)
* Quests!
  * A new robust quest system
  * DataPad quest log
  * New dialog quests
  * Rewards and quest lines
* Contract Market machine for side quest generation
* Android now respawn with a fixed amount of battery
* Improved Android HUD with more customizable options
* New Weapons
  * Plasma Shotgun
  * Ion Sniper
* New mutant scientist mob
* Rogue androids can now have teams once spawned from Android spawners
  * Rogue android with different teams fight each other
* Performance improvements for gravitational anomalies
* New Android abilities
  * Android shield is now toggleable and has a cooldown
  * New shockwave ability
  * New Flash Cooling ability
* More guide entries in the DataPad
* More work done on the still WIP Starmap
* Removed CofhLib dependency
* Android Transformation is now a Quest
* Memory and Network improvements (because of BTM)
* Improved Matter Plasma pipes (still in beta)
* New Random Legendary Android Parts
* A whole ton on new Event added to API
* Implemented Google Analytics for gathering anonymous statistical data (can be disabled).
* New Scope Module

#### 0.4.0

* Fixed Data Pad GUI
* New Omni Tool weapon/tool
* Weapon System overhauled
  * new Phaser model
  * more sounds
  * new improved effect
  * new accuracy system
  * fixed server clients now seeing phaser fire
* Fixed desyncing of Phaser Rifle shots between client and server
* Performance improvements on Gravitational anomalies and Matter Network machines
* Redstone mode on machines now works
* Gravitational anomaly improvements 
  * Anomaly now has realistic gravity with a distance squared falloff
  * Now has a minimal event horizon of 1 block. Makes it easier to swallow items when small.
  * Fixed Gravitational anomalies destroying blocks even when stabilized
  * Blocks that are further away are harder to destroy 
  * Anomalies can now be collapsed by nether stars
* Updated forge to 10.13.4.1517
* Fixed machines not dropping inventory
* Fixed Matter Registry not saving to file
* Androids now respawn with a full battery
* Lots of new decorative blocks
* New yellow android pill for resetting android abilities
* Android pills now can be replicated
* Android transformation is now not deadly in hardcore mode
* New ingame command for adding items to the Matter Registry

#### 0.4.0-RC4-Hotfix 1

* Fixed Android Abilities not working properly with multiple androids in SMP.

#### 0.4.0-RC4

* Removed matter fuel calculation.
* Fixed Android Energy duplicate ID.
* Some rendering optimizations.
* Matter Storage upgrade now affects the Replicator.
* Fixed speed dropping to 0 with 2 or more Hyper Speed Upgrades.
* New Data Pad that provides information and guides on Matter Overdrive.
* Added config for Gravitational Anomaly entity pulling and block destruction.
* Organized config options (may need a config rebuild).
* Fixed multiple Energy pack consumption.
* Fixed Damage reduction of  the Nano Armour ability.
* The Android Ability Use Key can now be mapped to the mouse.
* Fixed Charging station Bounding box.
* Fixed Icons (can now be re-textured with higher resolution).
* Rouge Android Parts can now be warn by Androids in the Android Station.
* Rouge Androids now increase max Health.
* New Tritanium Spine part. Can be warn by Androids.
* Android HUD config options for position and color.
* New Minimap ability.
* Implemented Tritanium Nuggets
* More info on Fusion Reactor Controller
* Updated forge to 10.13.4.1492

#### 0.4.0-RC3-HHotfix 3

* Fixed Matter Plasma Fluid Server Crash
* Fully fixed Matter Calculation with mods that have messed up item names

#### 0.4.0-RC3-HHotfix 2

* Fixed Entity ID Duplication
* Fixed Matter Registration Crashes 
* Added Debug Options to Config
* Fixed Machine Options now working
* Added Entity ID options to Config

#### 0.4.0-RC3-Hotfix

* Matter Plasma is now a forge fluid
* Fixed some server crashes
* Removed matter from TE buckets
* Fixed Router GUI
* Fixed Version Checking Crashing

#### 0.4.0-RC3

* New animations on the Matter Analyzer and Matter Recycler
* Matter Network optimizations
* Matter Analyzer will not analyze items that are fully analyzed in the Network
* Lots more config Options
* Mod Blacklisting for Recipe Matter Calculation
* Matter Network Filters (Network Flash Drive)
* Rewritten comprehensive API
* All kinds of API events
* Fixed Pattern Monitor GUI
* New Holographic Sign
* a bunch of changed recipes
* Mater Registration Improvements (Linear Registration and a lot more ore dictionary items)
* Increased Matter Transfer between machines
* Lowered Replicator and Decomposer fail rate
* New Energy and Matter Storage Upgrades
* Increased Replication Speed drastically for higher amounts of matter
* New Phaser Rifle Weapon
* Weapon System overhaul
* Weapon GUI for Android players
* Fixed Crash when putting unused weapon in Weapon Station
* New Energy Packs for easy weapon reloading
* Added matter Overdrive Ores to Ore Dictionary
* Improved Transporter GUI and increased Upgrade slot count
* New Hyper speed upgrade
* New Transport Flash Drive for loading Transporter locations easily
* Weapons are now enchantable
* New Enchantment Overclock
* New Command for Forcing Recipe Matter ReCaluclation
* New Dialog System with Mad Scientist
* New Tritanium Glass

#### 0.4.0-RC2

* Fixed Some Server Crashes
* Fixed Mod Compatibility, now Computercraft and Waila are no longer dependencies 
* More Computercraft and Open Computers Integration
* Added whole bunch of new config options from machine energy use to dimension blacklisting
* More Starmap World, can now claim planets and ships require ship factories.
* New Android Abilities, such as Cloak and Nightvision
* Abilities are now either passive or active
* Added new Ability Wheel for choosing active ability easily
* Fixed Server Starmap Camera flickering
* New block Charging Station, for charging Android Players
* Machine Rendering Optimizations
* Ores now spawn in all dimensions except ones listed in the blacklist
* Shield Ability now takes more power
* New Weapon Module: Healing Barrel
* More Phaser hit effects dependant on used modules
* Mad Scientist now has Matter Overdrive specific trades
* The Weapon Module: Incendiary Filter now lights flammable blocks on fire
* Health now displayed on the Android HUD
* New Blue Pill and Red Pill for easy Android transformations. Can be found in stronghold chests and are sold by the Mad Scientist
* Matter Overdrive now only supports Java 8 and above

#### 0.4.0-RC1

* Set maximum wrench stack size to 1 (simeon)
* Fix dismantling of blocks by checking player ID instead of name (simeon)
* Add Star Map zoom level (simeon)
* Add Thermal Expansion Pulverizer compatibility (shadowfacts)
* Fix Data Watcher ID (simeon)
* Add Ex Nihilo Sieve compatibility (shadowfacts)
* Add EnderIO SAG Mill compatibility (shadowfacts)
* Hide NEI in the Star Map GUI (shadowfacts)
* Fix Transporter English localization (shadowfacts)
* Add more Rogue Android spawn biomes, allows Rogue Androids to spawn in RWG biomes (simeon)
* Start WAILA compatibility (simeon & shadowfacts)
* Split nanobot android ability into two branches (simeon)
* Add android attack ability (simeon)

#### 0.0.0

* start of project