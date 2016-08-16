package com.biel.sampleoor.reportmodel1;

import java.util.ArrayList;
import java.util.List;

import com.biel.oor.Report;
import com.biel.xre.generation.XHTMLFragment;
import com.biel.xre.generation.xhtml.LinearLayout;
import com.biel.xre.generation.xhtml.Literal;
import com.biel.xre.generation.xhtml.Tag;
import com.biel.xre.generation.xhtml.attributes.StyleAttribute;
import com.biel.xre.generation.xhtml.attributes.TagAttributes;
import com.biel.xre.generation.xhtml.tags.*;

public class TodoListReport extends Report {
	//MODEL
	public class TodoListModel extends Model{

		private List<String> todoList = new ArrayList<>();

		public List<String> getTodoList() {
			return todoList;
		}
		
	}
	
	//CONTROLLER
	public class TodoListController extends Controller{
		public int getElementCount(){
			return getModel().getTodoList().size();
		}
	}
	
	//VIEW
	public class TodoListView extends View{
		public XHTMLFragment getHeading(){
			return new H(1, "Todo list");	
		}
		public XHTMLFragment getBody(){
			return new LinearLayout(getList(), new Literal(getController().getElementCount() + " elements"));
		}
		protected XHTMLFragment getList() {
			Tag tag = new Tag("b", "List: ");
			Tag list = new Div(getListContents(), new TagAttributes(new StyleAttribute("background-color: gold;")));
			return new Div(new LinearLayout(tag, list), new TagAttributes(new StyleAttribute("background-color: lightblue;")));
		}
		protected XHTMLFragment getListContents() {
			return new Literal(String.join(", ", getModel().getTodoList()));
		}
		@Override
		protected String getXHTML() {
			// TODO Auto-generated method stub
			String xhtml = new LinearLayout(getHeading(), getBody()).getXHTML();
			return xhtml;
		}
		
	}
	
	public TodoListModel getModel() {
		return super.getModel(TodoListModel.class);
	}
	public TodoListController getController(){
		return super.getController(TodoListController.class);
	}
	public TodoListView getView(){
		return super.getView(TodoListView.class);
	}
}
