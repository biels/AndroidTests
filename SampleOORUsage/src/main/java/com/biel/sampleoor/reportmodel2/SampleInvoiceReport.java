package com.biel.sampleoor.reportmodel2;

import com.biel.oor.Report;
import com.biel.sampleoor.reportmodel1.TodoListReport.TodoListController;
import com.biel.sampleoor.reportmodel1.TodoListReport.TodoListModel;
import com.biel.sampleoor.reportmodel1.TodoListReport.TodoListView;

public class SampleInvoiceReport extends Report {

	//MODEL
	class SampleInvoiceModel extends Model{
		
	}
	
	//VIEW
	class SampleInvoiceController extends Controller{
		
	}
	
	//CONTROLLER
	class SampleInvoiceView extends View{

		@Override
		protected String getXHTML() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public SampleInvoiceModel getModel() {
		return super.getModel(SampleInvoiceModel.class);
	}
	public SampleInvoiceController getController(){
		return super.getController(SampleInvoiceController.class);
	}
	public SampleInvoiceView getView(){
		return super.getView(SampleInvoiceView.class);
	}
}
