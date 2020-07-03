package com.olddivinepotions;

import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
enum ItemOverride
{
    DIVINE_BATTLEMAGE_POTION_4(ItemID.DIVINE_BATTLEMAGE_POTION4),
    DIVINE_BATTLEMAGE_POTION_3(ItemID.DIVINE_BATTLEMAGE_POTION3),
    DIVINE_BATTLEMAGE_POTION_2(ItemID.DIVINE_BATTLEMAGE_POTION2),
    DIVINE_BATTLEMAGE_POTION_1(ItemID.DIVINE_BATTLEMAGE_POTION1),

    DIVINE_BASTION_POTION_4(ItemID.DIVINE_BASTION_POTION4),
    DIVINE_BASTION_POTION_3(ItemID.DIVINE_BASTION_POTION3),
    DIVINE_BASTION_POTION_2(ItemID.DIVINE_BASTION_POTION2),
    DIVINE_BASTION_POTION_1(ItemID.DIVINE_BASTION_POTION1),

    EGNIOL_POTION_1(ItemID.EGNIOL_POTION_1),
    EGNIOL_POTION_2(ItemID.EGNIOL_POTION_2),
    EGNIOL_POTION_3(ItemID.EGNIOL_POTION_3),
    EGNIOL_POTION_4(ItemID.EGNIOL_POTION_4);

    private int itemID;

    ItemOverride(int itemId)
    {
        this.itemID = itemId;
    }
}

