package com.gencube.sbjc.springboot.config;

/**
 *
 * @author gencube
 */
public interface CurdPaths {

    public static final String FIND_ID_PATH = "/{id}";
    public static final String FIND_ID_INFO = "Find a item with id within records.";

    public static final String LIST_ALL_PATH = "/list";
    public static final String LIST_ALL_INFO = "List all records.";

    public static final String SIZE_ALL_PATH = "/size";
    public static final String SIZE_ALL_INFO = "Get the size of the records.";

    public static final String ADD_PATH = "/add";
    public static final String ADD_INFO = "Add new item into records.";

    public static final String EDIT_PATH = "/edit/{id}";
    public static final String EDIT_INFO = "Edit the record with id.";

    public static final String DEL_PATH = "/del/{id}";
    public static final String DEL_INFO = "Delete the record with id.";

}
