import java.util.*;

/**
 * Store allows {@link User player} to buy item
 * which is also owned by player
 */
public class Store
{
	/**
	 * Create new Store which is owned by specified {@link User player}
	 * 
	 * @param owner The store owner
	 */
	public Store(User owner)
	{
		this.owner = owner;
	}

	/**
	 * Check if specified player is the owner of this store
	 * 
	 * @param player {@link User player} to check
	 * @return <code>true</code> if it's store owner, <code>false</code>
	 *         otherwise
	 */
	public boolean isOwner(User player)
	{
		return owner == player;
	}

	/**
	 * Add {@link Item} to store. Rest assured items passed are unusable
	 * after passed to this function
	 * @param player Store {@link #isOwner(User) owner}
	 * @param items List of items to add
	 * @param prices List of item prices
	 * @exception IllegalArgumentException if player passed is not store owner
	 * @exception IllegalArgumentException if <code>items.length</code> is not
	 *              equal <code>prices.length</code>
	 */
	public void stockItems(User player, Item[] items, int[] prices)
	{
		// Sanity check: Ensure only store owner can stock items
		if (owner != player)
			throw new IllegalArgumentException("player != owner");

		// Sanity check: ensure all the arrays have same length
		if (items.length != prices.length)
			throw new IllegalArgumentException("length doesn't match each other");

		// Stock items, in loop
		for (int i = 0; i < items.length; i++)
		{
			boolean found = false;

			// FIXME: Optimize this loop?
			for (StoreItem storeItem: this.items)
			{
				if (storeItem.isContainedItem(items[i]))
				{
					storeItem.add(items[i]);
					found = true;
					break;
				}
			}

			// If not found, add new StoreItem
			if (!found)
				this.items.add(new StoreItem(items[i], prices[i], this, this.owner));
		}
	}

	/**
	 * Remove item from store
	 * @param item {@link StoreItem encapsulated item} for this store
	 */
	public void removeItem(StoreItem item)
	{
		items.remove(item);
	}

	// List of items for sale
	protected ArrayList<StoreItem> items;
	// Store owner, which is a user
	protected User owner;
}