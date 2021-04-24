/**
 * Item object encapsulated to prevent item stealing
 */
public final class StoreItem
{
	/**
	 * Construct new StoreItem
	 * 
	 * @param item The {@link Item} object to encapsulate
	 * @param price The item price
	 * @param store {@link Store} who owns the item
	 * @param owner Store {@link User} owner
	 * @exception IllegalArgumentException if <code>owner</code> passed is not
	 *              the store owner
	 **/
	public StoreItem(Item item, int price, Store store, User owner)
	{
		this.item = item;
		this.price = price;
		this.store = store;

		if (store.isOwner(owner))
			this.owner = owner;
		else
			throw new IllegalArgumentException("player is not store owner");
	}

	/**
	 * Retrieve the name of the item
	 * 
	 * @return Encapsulated {@link Item} name
	 **/
	public String getName()
	{
		return item.getName();
	}

	/**
	 * Retrieve item description
	 * 
	 * @return Encapsulated {@link Item} description
	 **/
	public String getDescription()
	{
		return item.getDescription();
	}

	/**
	 * Retrieve the quantity of the item
	 * 
	 * @return Encapsulated {@link Item} quantity
	 **/
	public int getAmount()
	{
		return item.getAmount();
	}

	/**
	 * Retrieve the price of the item
	 * 
	 * @return Price of the {@link Item} sale
	 **/
	public int getPrice()
	{
		return price;
	}

	/**
	 * Buy this item
	 * 
	 * @param player {@link User Player} who want to bought the item
	 * @param amount Amount to bought
	 * @return {@link Item} with specified <code>amount</code> of quantity
	 * @exception IllegalArgumentException if the player doesn't have enough
	 *              money
	 * @exception IllegalArgumentException if the amount requested is more
	 *              than {@link #getAmount()}
	 **/
	public Item buy(User player, int amount)
	{
		if (amount > item.getAmount())
			throw new IllegalArgumentException("item amount < requested amount");

		int totalPrice = price * amount;
		if (player.getMoney() < totalPrice)
			throw new IllegalArgumentException("not enough money");
		
		player.addMoney(-totalPrice);
		owner.addMoney(totalPrice);
		Item result = item.separate(amount);

		// If item quantity is 0, remove it from shop item list
		if (item.getAmount() == 0)
			store.removeItem(this);
		
		return result;
	}

	/**
	 * Check whetever an {@link Item} is encapsulated in this <code>StoreItem</code>
	 * 
	 * @param item Item to compare with
	 * @return <code>true</code> if specified item is same as one that's encapsulated
	 *   inside this <code>StoreItem</code>, <code>false</code> otherwise.
	 **/
	public boolean isContainedItem(Item item)
	{
		return this.item.equals(item);
	}

	/**
	 * Add quantity of the encapsulated {@link Item}
	 * 
	 * @param item Same encapsulated item which has quantity &gt; 0
	 * @exception IllegalArgumentException if encapsulated item is not equal to
	 *              passed item.
	 **/
	public void add(Item item)
	{
		this.item.add(item);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof StoreItem)
		{
			StoreItem a = (StoreItem) obj;
			return a.item.equals(this.item) && this.store == a.store;
		}
		
		return false;
	}

	@Override
	public int hashCode()
	{
		return item.hashCode() + store.hashCode() + price;
	}

	
	/** Item object */
	private Item item;
	/** Item price */
	private int price;
	/** Store parent object */
	private Store store;
	/** Store owner */
	private User owner;
}