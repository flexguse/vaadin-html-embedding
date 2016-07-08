/**
 * 
 */
package de.flexguse.vaadin.demo.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Christoph Guse
 *
 */
@Theme(ValoTheme.THEME_NAME)
@SpringUI
public class ApplicationUI extends UI {

	private static final long serialVersionUID = 3145985078074281518L;

	private TextArea textArea;

	@Override
	protected void init(VaadinRequest request) {

		TabSheet appContent = new TabSheet();
		appContent.setSizeFull();
		setContent(appContent);

		appContent.addTab(createInputTab(), "Text Input");
		appContent.addTab(createOutputTab(), "Text Output");

	}

	/**
	 * This helper method creates the TAB content for text input.
	 * 
	 * @return
	 */
	private Component createInputTab() {

		HorizontalLayout inputBar = new HorizontalLayout();
		inputBar.setDefaultComponentAlignment(Alignment.BOTTOM_LEFT);
		inputBar.setWidth(100, Unit.PERCENTAGE);
		inputBar.setSpacing(true);
		inputBar.setMargin(true);

		TextField textInput = new TextField("Give me some text");
		textInput.setWidth(100, Unit.PERCENTAGE);
		inputBar.addComponent(textInput);

		Button addText = new Button("add text (click or press enter)", FontAwesome.PLUS);
		addText.setClickShortcut(KeyCode.ENTER);
		addText.addClickListener(clickEvent -> {
			textArea.setValue(String.format("%s\n%s", textArea.getValue(), textInput.getValue()));
			textInput.setValue("");
		});
		inputBar.addComponent(addText);

		return inputBar;

	}

	/**
	 * This helpoer method creates the TAB content for the text output.
	 * 
	 * @return
	 */
	private Component createOutputTab() {

		textArea = new TextArea();
		textArea.setSizeFull();

		return textArea;
	}

}
