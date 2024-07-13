Lets you set the EMC values of items and the Philosopher's Stone transformations blocks with the ProjectE mod. Examples are shown below.

Note: Modrinth does not host a version of ProjectE, so to use this mod you must download it from another source

In server_scripts:

```
ProjectEEvents.setEMC(event => {
    // sets the absolute emc value of an item
    event.setEMC("minecraft:cobblestone", 10000) // alias. setEMCAfter

    // sets the emc of an item before anything else happens
    // this can sometimes result in this emc value not being
    // set, but also it allows for emc values to be generated
    // from this one; i.e crafting recipes
    event.setEMCBefore("minecraft:stick", 10000);
})
```

In startup_scripts:
```
ProjectEEvents.registerWorldTransmutations(event => {
    event.transform("minecraft:tnt", "minecraft:oak_planks");
})
```

[MasterOfBob777](https://modrinth.com/user/MasterOfBob777) original mod author