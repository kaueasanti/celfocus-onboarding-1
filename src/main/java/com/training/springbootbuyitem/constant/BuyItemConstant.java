package com.training.springbootbuyitem.constant;

public class BuyItemConstant {


	/**
	 * Entities
	 */
	public static final String ITEM = "Item";

	/**
	 * Header Names
	 */
	public static final String TRACE_ID_HEADER = "Trace-Id";

	/**
	 * Messages
	 */
	public static final String ENTITY_NOT_FOUND_MSG = "Entity {%s} :: UID {%s} not found.";
	public static final String LOGGING_HANDLER_INBOUND_MSG = "Received HTTP [%s] Request to [%s] at [%s]";
	public static final String LOGGING_HANDLER_OUTBOUND_MSG = "Responded with Status [%s] at [%s]";
	public static final String LOGGING_HANDLER_PROCESS_TIME_MSG = "Total processing time [%s] ms";

    public static final String STOCK_NOT_AVAILABLE_MSG = "Item {%s} not available in stock";
    public static final String INVALID_QUANTITY_MSG = "The quantity provided for restock should be greater then zero";
	public static final String NULL_ITEM_MESSAGE_MSG = "This item is null";
    public static final String USER_NOT_FOUND_MESSAGE_MSG = "Could not found a user with id {%d}";
}