package com.biel.sampleoor.reportmodel1;

import java.util.ArrayList;
import java.util.List;

import com.biel.sampleoor.reportmodel1.TodoListReport.TodoListController;
import com.biel.sampleoor.reportmodel1.TodoListReport.TodoListModel;
import com.biel.sampleoor.reportmodel1.TodoListReport.TodoListView;
import com.biel.xre.generation.XHTMLFragment;
import com.biel.xre.generation.xhtml.LinearLayout;
import com.biel.xre.generation.xhtml.Tag;

public class ExtendedTodoListReport extends TodoListReport {
	//MODEL
	public class ExtendedTodoListModel extends TodoListModel{
		private List<Integer> completion = new ArrayList<>();

		public List<Integer> getCompletion() {
			return completion;
		}
		
	}
	
	//CONTROLLER
	public class ExtendedTodoListController extends TodoListController{
		
	}
	
	//VIEW
	public class ExtendedTodoListView extends TodoListView{
		@Override
		protected XHTMLFragment getListContents() {
			List<Tag> listItems = new ArrayList<>();
			List<String> todoList = getModel().getTodoList();
			for (int i = 0; i < todoList.size(); i++) {
				List<Integer> completion = getModel().getCompletion();
				listItems.add(new Tag("li", todoList.get(i) + " (" + completion.get(i)  + "%)"));
			}
			return new Tag("ul", new LinearLayout(listItems));
		}
	}
	
	public ExtendedTodoListModel getModel() {
		return super.getModel(ExtendedTodoListModel.class);
	}
	public ExtendedTodoListController getController(){
		return super.getController(ExtendedTodoListController.class);
	}
	public ExtendedTodoListView getView(){
		return super.getView(ExtendedTodoListView.class);
	}
}
