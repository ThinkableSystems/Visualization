/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.thinksys.mainwindow.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.FloatFieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.form.ComboBox;
import com.google.gwt.user.client.ui.Image;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.client.widgets.chart.yui.LineChart;
import com.gwtext.client.widgets.chart.yui.NumericAxis;  
import com.gwtext.client.widgets.chart.yui.SeriesDefY;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.gwtext.client.widgets.layout.AbsoluteLayout;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MainWindow implements EntryPoint {
	private Button clickMeButton;
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();

		clickMeButton = new Button();
		rootPanel.add(clickMeButton, 10, 647);
		clickMeButton.setText("Lets Visualize....Bitches!!!");

		MemoryProxy proxy = new MemoryProxy(getData());  
		RecordDef recordDef = new RecordDef(  
				new FieldDef[]{  
						new StringFieldDef("month"),  
						new FloatFieldDef("rent"),  
						new FloatFieldDef("utilities")  
				}  
				);  

		ArrayReader reader = new ArrayReader(recordDef);  
		final Store store = new Store(proxy, reader);  
		store.load();  

		SeriesDefY[] seriesDef = new SeriesDefY[]{  

				new SeriesDefY("Rent", "rent"),  
				new SeriesDefY("Utilities", "utilities")  

		};  

		NumericAxis currencyAxis = new NumericAxis();  
		currencyAxis.setMinimum(800);  
		currencyAxis.setLabelFunction("formatCurrencyAxisLabel"); 

		String[][] patientArray = new String[][] {new String[]{"kabenla"}, 
				new String[]{"leonya"}, 
				new String[]{"yaw"}, 
				new String[]{"Gemma"},
				new String[]{"Adwoa"}
		};


		final Store patientStore = new SimpleStore(new String[]{"Patient_Name"}, patientArray);
		patientStore.load();

		com.gwtext.client.widgets.form.FormPanel formPanel = new com.gwtext.client.widgets.form.FormPanel();
		formPanel.setLayout(new FormLayout());
		formPanel.setTitle("");



		ComboBox comboBox_2 = new ComboBox("Variable 1", "combo_box", 100);
		formPanel.add(comboBox_2);
		rootPanel.add(formPanel, 234, 40);
		formPanel.setSize("210px", "39px");

		com.gwtext.client.widgets.form.FormPanel formPanel_1 = new com.gwtext.client.widgets.form.FormPanel();
		formPanel_1.setTitle("");

		ComboBox comboBox_1 = new ComboBox("New combobox", "combo_box", 100);
		comboBox_1.setFieldLabel("Patient Name");
		comboBox_1.setMinChars(1); 
		comboBox_1.setStore(patientStore);
		comboBox_1.setDisplayField("Patient_Name");
		comboBox_1.setMode(ComboBox.LOCAL);  
		comboBox_1.setTriggerAction(ComboBox.ALL);
		comboBox_1.setEmptyText("Select a Patient");

		comboBox_1.setHideTrigger(false);
		formPanel_1.add(comboBox_1);
		rootPanel.add(formPanel_1, 10, 40);
		formPanel_1.setSize("218px", "39px");

		com.gwtext.client.widgets.form.FormPanel formPanel_2 = new com.gwtext.client.widgets.form.FormPanel();
		formPanel_2.setTitle("");

		ComboBox comboBox = new ComboBox("Variable 2", "combo_box", 100);
		formPanel_2.add(comboBox);
		rootPanel.add(formPanel_2, 453, 40);
		formPanel_2.setSize("210px", "39px");
				
						final LineChart chart = new LineChart();  
						chart.setTitle("Monthly Expenses");  
						chart.setWMode("transparent");  
						chart.setStore(store);  
						chart.setSeries(seriesDef);  
						chart.setXField("month");  
						chart.setYAxis(currencyAxis);  
						chart.setDataTipFunction("getDataTipText");  
						chart.setExpressInstall("js/yui/assets/expressinstall.swf");  
						chart.setWidth(500);  
						chart.setHeight(400);
						chart.setLayout(new AbsoluteLayout());
						rootPanel.add(chart, 40, 159);
						chart.setSize("500px", "500px");
				chart.setPosition(20, 100);


		clickMeButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				Window.alert("Hello, GWT World!");
			}
		});
	}
	private static Object[][] getData() {  
		return new Object[][]{  
				new Object[]{"January", new Double(880.00), new Double(894.68)},  
				new Object[]{"February", new Double(880.00), new Double(901.35)},  
				new Object[]{"March", new Double(880.00), new Double(889.32)},  
				new Object[]{"April", new Double(880.00), new Double(884.71)},  
				new Object[]{"May", new Double(910.00), new Double(879.811)},  
				new Object[]{"June", new Double(910.00), new Double(897.95)}  
		};  
	} 
}
