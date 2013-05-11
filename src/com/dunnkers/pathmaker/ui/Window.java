package com.dunnkers.pathmaker.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.border.Border;

import com.dunnkers.pathmaker.Configuration;
import com.dunnkers.pathmaker.ui.worldmap.WorldMapController;
import com.dunnkers.pathmaker.ui.worldmap.WorldMapModel;
import com.dunnkers.pathmaker.ui.worldmap.WorldMapView;
import com.dunnkers.pathmaker.util.CodeFormat;
import com.dunnkers.pathmaker.util.TileMath;
import com.dunnkers.pathmaker.util.TileMode;
import com.dunnkers.util.resource.ResourcePath;

/**
 * 
 * @author Dunnkers
 */
/*
 * TODO make all components independant of 
 * jframe or japplet
 * TODO make buttonbar independant in its own class
 * TODO make DunkPathMaker class add a jframe for that
 */
public class Window extends Container {

	private static final long serialVersionUID = 1L;
	private final ButtonBar buttonBar;
	private final ToolBar toolBar;
	private final JLabel statusLabel;

	private final WorldMapModel worldMapModel;
	private final WorldMapView worldMapView;
	private final InteractiveWorldMapController worldMapController;

	public Window(final WindowModel windowModel) {
		worldMapModel = new WorldMapModel();
		worldMapView = new WorldMapView(worldMapModel);
		worldMapController = new InteractiveWorldMapController(worldMapModel,
				worldMapView);
		
		buttonBar = new ButtonBar(windowModel, worldMapModel, this);
		{
			statusLabel = new JLabel("Hover over the map to start", JLabel.LEFT);
			final Border paddingBorder = BorderFactory.createEmptyBorder(3, 5,
					3, 5);
			statusLabel.setBorder(BorderFactory.createCompoundBorder(
					statusLabel.getBorder(), paddingBorder));
		}

		// TODO use mvc here.
		toolBar = new ToolBar("Tools", worldMapController, this) {
			private static final long serialVersionUID = 1L;

			@Override
			public CodeFormat getCodeFormat() {
				return windowModel.getCodeFormat();
			}
		};
	}
	
	public void initContentPane(final Container contentPane) {
		contentPane.add(toolBar, BorderLayout.PAGE_START);
		contentPane.add(statusLabel, BorderLayout.SOUTH);
		contentPane.add(worldMapView, BorderLayout.CENTER);
	}
	
	public void initJMenuBar(final JFrame frame) {
		frame.setJMenuBar(buttonBar);
	}
	
	public void initJMenuBar(final JApplet applet) {
		applet.setJMenuBar(buttonBar);
	}

	public class InteractiveWorldMapController extends WorldMapController {

		public InteractiveWorldMapController(WorldMapModel worldMapModel,
				WorldMapView worldMapView) {
			super(worldMapModel, worldMapView);
		}

		@Override
		public void onMouseMove(final MouseEvent e) {
			super.onMouseMove(e);
			final Point tilePoint = TileMath.getTile(e.getPoint());
			final String tile = String.format("(%s, %s)", tilePoint.x,
					tilePoint.y);
			statusLabel.setText("Current tile: " + tile);
		}

		@Override
		public void setClear(boolean enabled) {
			super.setClear(enabled);
			toolBar.getClear().setEnabled(enabled);
		}

		@Override
		public void setRedo(boolean enabled) {
			super.setRedo(enabled);
			toolBar.getRedo().setEnabled(enabled);
		}

		@Override
		public void setUndo(boolean enabled) {
			super.setUndo(enabled);
			toolBar.getUndo().setEnabled(enabled);
		}

		@Override
		public void setGenerate(boolean enabled) {
			super.setGenerate(enabled);
			toolBar.getGenerate().setEnabled(enabled);
		}
	}

	public class ButtonBar extends JMenuBar {

		private static final long serialVersionUID = 1L;
		private final SettingsMenu settingsMenu;
		private final MapMenu mapMenu;
		private final HelpMenu help;

		public ButtonBar(final WindowModel windowModel, final WorldMapModel worldMapModel, final Component parentComponent) {
			this.settingsMenu = new SettingsMenu("Settings", windowModel, worldMapModel, parentComponent);
			this.settingsMenu.setIcon(Configuration.ICON_SETTINGS.getIcon());
			this.mapMenu = new MapMenu("Map");
			this.mapMenu.setIcon(Configuration.ICON_MAP_16.getIcon());
			this.help = new HelpMenu("Help", parentComponent);
			this.help.setIcon(Configuration.ICON_HELP.getIcon());
			init();
		}

		public void init() {
			add(settingsMenu);
			add(mapMenu);
			add(help);
		}

		public SettingsMenu getSettingsMenu() {
			return settingsMenu;
		}
	}
}
