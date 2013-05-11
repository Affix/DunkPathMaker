package com.dunnkers.pathmaker;

import java.awt.Dimension;

import com.dunnkers.util.resource.Resource;
import com.dunnkers.util.resource.ResourcePath;

/**
 * 
 * @author Dunnkers
 */
public class Configuration {

	public static final double APPLICATION_VERSION_MAJOR = 2;
	public static final double APPLICATION_VERSION_MINOR = 0.04;
	public static final double APPLICATION_VERSION = APPLICATION_VERSION_MAJOR
			+ APPLICATION_VERSION_MINOR;
	public static final String APPLICATION_TITLE = "DunkPathMaker";
	public static final String APPLICATION_ALIAS = "Create your paths with ease!";

	public static final String WINDOW_TITLE = APPLICATION_TITLE + " v"
			+ APPLICATION_VERSION + " - " + APPLICATION_ALIAS;
	public static final Dimension WINDOW_SIZE = new Dimension(750, 600);

	// TODO ResourcePath: only store Resource once; it is now stored in all
	// ResourcePaths
	public static final Resource RESOURCE = new Resource(DunkPathMaker.class);
	public static final ResourcePath IMAGE_MAP_PATH = new ResourcePath(RESOURCE,
			"res/runescape-map-07.jpg");
	public static final ResourcePath ICON_MAP_16 = new ResourcePath(RESOURCE,
			"res/icon-map-16x16.png");
	public static final ResourcePath ICON_MAP_32 = new ResourcePath(RESOURCE,
			"res/icon-map-32x32.png");
	public static final ResourcePath ICON_MAP_48 = new ResourcePath(RESOURCE,
			"res/icon-map-48x48.png");
	public static final ResourcePath[] ICON_MAP = {
			ICON_MAP_16,
			ICON_MAP_32,
			ICON_MAP_48 };
	public static final ResourcePath ICON_AREA = new ResourcePath(RESOURCE,
			"res/icon-area.png");
	public static final ResourcePath ICON_MOUSE = new ResourcePath(RESOURCE,
			"res/icon-mouse.png");
	public static final ResourcePath ICON_PATH = new ResourcePath(RESOURCE,
			"res/icon-path.png");
	public static final ResourcePath ICON_REDO = new ResourcePath(RESOURCE,
			"res/icon-redo.png");
	public static final ResourcePath ICON_SETTINGS = new ResourcePath(RESOURCE,
			"res/icon-settings.png");
	public static final ResourcePath ICON_UNDO = new ResourcePath(RESOURCE,
			"res/icon-undo.png");
	public static final ResourcePath ICON_HELP = new ResourcePath(RESOURCE,
			"res/icon-help.png");
	public static final ResourcePath ICON_CLEAR = new ResourcePath(RESOURCE,
			"res/icon-clear.png");

	// default values
	public static final int INITIAL_DRAG_SENSITIVITY = 5;
	public static final int MAX_TILE_RADIUS = 15;
	

	private Configuration() {
	}
}
