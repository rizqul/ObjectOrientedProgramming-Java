import java.util.*;

import id.co.npad93.itemstore.items.*;

public class Main 
{
	private static class Xorshift
	{
		private static long wangHash64(long key)
		{
			key = (~key) + (key << 21); // key = (key << 21) - key - 1;
			key = key ^ (key >>> 24);
			key = (key + (key << 3)) + (key << 8); // key * 265
			key = key ^ (key >>> 14);
			key = (key + (key << 2)) + (key << 4); // key * 21
			key = key ^ (key >>> 28);
			key = key + (key << 31);
			return key;
		}

		public Xorshift(long seed)
		{
			setSeed(seed);
		}

		public Xorshift()
		{
			this(System.nanoTime() * 88172645463325252L);
		}

		public void setSeed(long seed)
		{
			do
			{
				seed = wangHash64(seed);
			} while (seed == 0);
			state = seed;
		}

		public long nextLong()
		{
			step();
			return state * 2685821657736338717L;
		}

		public double nextDouble()
		{
			return Double.longBitsToDouble(((0x3FFL) << 52) | (nextLong() >> 12)) - 1.0;
		}

		private long state;

		private void step()
		{
			state ^= (state >>> 12);
			state ^= (state << 25);
			state ^= (state >>> 27);
		}
	}

	public static void main(String[] args) throws Exception
	{
		// Initialize RNG
		Xorshift rng;
		if (args.length > 0)
			rng = new Xorshift(Long.parseLong(args[0]));
		else
			rng = new Xorshift();
		
		// Interaction type: Player-Player vs Player-Store
		if (rng.nextDouble() >= 0.5)
			interactionPlayerByPlayer(rng);
		else
			interactionPlayerByStore(rng);
	}

	private static Character[] syllables = {'a', 'i', 'u', 'e', 'o'};

	private static <T> boolean contains(T[] a, T v)
	{
		for (int i = 0; i < a.length; i++)
			if (a[i] == v)
				return true;
		
		return false;
	}

	/** Generate random name */
	private static String generateName(Xorshift rng)
	{
		int syllableLength = 1 + (int) (rng.nextDouble() * 6);
		int length = 0;
		char[] ch = new char[syllableLength * 3];

		for (int i = 0; i < syllableLength; i++)
		{
			char syllable = syllables[(int) (rng.nextDouble() * 5)];
			double cpre = rng.nextDouble() * 0.5 + 0.3;
			double cpost = rng.nextDouble() * 0.4 + 0.3;
			boolean doPre = false, doPost = false;

			if (syllableLength == 1)
				if (rng.nextDouble() >= 0.5)
					doPre = true;
				else
					doPost = true;
			
			if (rng.nextDouble() >= cpre || doPre)
			{
				// prepend
				char pre;
				do
				{
					pre = (char) (97 + rng.nextDouble() * 26);
				} while (Main.<Character>contains(syllables, pre));
				ch[length++] = pre;
			}

			ch[length++] = syllable;

			if (rng.nextDouble() >= cpost || doPost)
			{
				// append
				char post;
				do
				{
					post = (char) (97 + rng.nextDouble() * 26);
				} while (Main.<Character>contains(syllables, post));
				ch[length++] = post;
			}
		}

		ch[0] = Character.toUpperCase(ch[0]);
		return new String(ch, 0, length);
	}

	private static UUID[] consumableItems = {
		Water.uuid,
		HPRestorator50.uuid
	};

	private static UUID[] usableItems = {
		LP21.uuid,
		ThermalSuit.uuid
	};

	private static void interactionPlayerByPlayer(Xorshift rng)
	{
		// Player-Player trade
		int money1 = (int) (rng.nextDouble() * 100.0) * 1000;
		User user1 = new User(generateName(rng), money1);
		int money2 = (int) (rng.nextDouble() * 100.0) * 1000;
		User user2 = new User(generateName(rng), money2);

		// Stock some items
		boolean[] user1Equipped = new boolean[usableItems.length];
		for (int i = 0; i < 10; i++)
		{
			boolean itemAdded = false;

			// 10% chance to have equipable item
			if (rng.nextDouble() < 0.1)
			{
				// Usable items
				int index = (int) (rng.nextDouble() * usableItems.length);
				if (user1Equipped[index] == false)
				{
					user1.addItem(ItemFactory.newItemFromUUID(usableItems[index], 1));
					user1Equipped[index] = true;
				}
			}

			if (!itemAdded)
				// Consumable items
				user1.addItem(ItemFactory.newItemFromUUID(
					consumableItems[(int) (rng.nextDouble() * consumableItems.length)], 1
				));
		}
	}

	private static void interactionPlayerByStore(Xorshift rng)
	{
		// TODO
	}
}