package com.olddivinepotions;

import java.awt.image.BufferedImage;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.SpritePixels;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ImageUtil;

@Slf4j
@PluginDescriptor(
	name = "Old Divine Potions",
	description = "Reverts the appearance of divine potions to their pre-July 2020 look.",
	tags = {"divine-pots", "egniol", "appearance", "reskin", "traditional", "icons", "inventory", "bank"},
	enabledByDefault = false
)
public class OldDivinePotionsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Override
	protected void startUp() throws Exception
	{
		clientThread.invoke(this::overrideItems);
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientThread.invoke(this::restoreItems);
	}

	private SpritePixels getFileSpritePixels(String file)
	{
		try
		{
			log.debug("Loading: {}", file);
			BufferedImage image = ImageUtil.getResourceStreamFromClass(this.getClass(), file);
			return ImageUtil.getImageSpritePixels(image, client);
		}
		catch (RuntimeException ex)
		{
			log.debug("Unable to load image: ", ex);
		}

		return null;
	}

	private void overrideItems()
	{
		for (ItemOverride itemOverride : ItemOverride.values())
		{
			String file = itemOverride.getItemID() + ".png";
			SpritePixels spritePixels = getFileSpritePixels(file);
			client.getSpriteOverrides().put(itemOverride.getItemID(), spritePixels);
		}
	}

	private void restoreItems()
	{
		client.getWidgetSpriteCache().reset();
		for (ItemOverride itemOverride : ItemOverride.values())
		{
			client.getSpriteOverrides().remove(itemOverride.getItemID());
		}
	}
}
