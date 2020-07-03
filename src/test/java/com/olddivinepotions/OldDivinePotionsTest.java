package com.olddivinepotions;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class OldDivinePotionsTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(OldDivinePotionsPlugin.class);
		RuneLite.main(args);
	}
}