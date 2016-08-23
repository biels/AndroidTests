package com.biel.sampleoor.reportmodel2;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.biel.oor.Report;
import com.biel.xre.generation.TableFragment;
import com.biel.xre.generation.TableFragment.TableRow;
import com.biel.xre.generation.XHTMLFragment;
import com.biel.xre.generation.xhtml.LinearLayout;
import com.biel.xre.generation.xhtml.Literal;
import com.biel.xre.generation.xhtml.Tag;
import com.biel.xre.generation.xhtml.attributes.StyleAttribute;
import com.biel.xre.generation.xhtml.attributes.TagAttributes;
import com.biel.xre.generation.xhtml.tags.Div;
import com.biel.xre.generation.xhtml.tags.H;

public class SampleInvoiceReport extends Report {

	//MODEL
	public class SampleInvoiceModel extends Model{
		public CompanyInfo companyInfo = new CompanyInfo();
		public ContactInfo contactInfo = new ContactInfo();
		public ProductList productList = new ProductList();
		//To override inner classes, override in the constructor
		public class CompanyInfo {
			private String name;
			private String slogan;
			private String city;
			private String address;
			private String zip;
			private String phone;
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getSlogan() {
				return slogan;
			}
			public void setSlogan(String slogan) {
				this.slogan = slogan;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public String getZip() {
				return zip;
			}
			public void setZip(String zip) {
				this.zip = zip;
			}
			public String getPhone() {
				return phone;
			}
			public void setPhone(String phone) {
				this.phone = phone;
			}

		}
		public class ContactInfo {
			private String name;
			private String phone;
			private String email;
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getPhone() {
				return phone;
			}
			public void setPhone(String phone) {
				this.phone = phone;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}


		}
		public class ProductInfo{
			private String name;
			private String description;
			private double price;
			private int amount;
			//Support for nested products
			private ArrayList<ProductInfo> products = new ArrayList<ProductInfo>();

			//Edit getters to match view's needs. Add getters for priceBeforeDiscount... 
			//Maybe merge product and productrequest into InvoiceProduct
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			protected double getPrice() {
				return price;
			}
			public void setPrice(double price) {
				this.price = price;
			}
			public ArrayList<ProductInfo> getProducts() {
				return products;
			}
			public void setProducts(ArrayList<ProductInfo> products) {
				this.products = products;
			}
			public int getAmount() {
				return amount;
			}
			public void setAmount(int amount) {
				this.amount = amount;
			}
			public double getTotal(){ //Directly calculated fields are part of the model
				return getPrice() * getAmount();
			}
		}
		public class ProductList{
			private List<? extends ProductInfo> productList = new ArrayList<>();
			//Discounts, taxes, etc.
			public List<? extends ProductInfo> getProductList() {
				return productList;
			}	
		}
		public CompanyInfo getCompanyInfo() {
			return companyInfo;
		}
		public ContactInfo getContactInfo() {
			return contactInfo;
		}
		public ProductList getProductList() {
			return productList;
		}

	}

	//CONTROLLER - ViewModel
	public class SampleInvoiceController extends Controller{
		/** 
		 *	Provides the product table information, which appears at the center of the invoice.
		 */
		public class ProductTable{
			public SampleInvoiceModel.ProductList getInnerModel(){
				return getModel().getProductList();
			}
//			public List<ProductInfo> getProductList(){
//				return 
//			}
			private double calculateGrandTotal(){
				int s = 0;
				for(SampleInvoiceModel.ProductInfo p : getInnerModel().getProductList())s+= p.getTotal();
				return s;
			}
			public String getGrandTotal(){
				return formatCurrencyField(calculateGrandTotal());
			}
		}
		public ProductTable getProductTable(){
			return new ProductTable();
		}
		/**
		 * Provides the necessary information to generate a specific row from the product table
		 */
		public class ProductTableRow{
			private int index;
			double total = 0.0;
			public ProductTableRow(int index) {
				this.index = index;
			}
			public SampleInvoiceModel.ProductInfo getInnerModel() {
				return getModel().getProductList().getProductList().get(index);
			}

			
			public String getTotal(){
				return formatCurrencyField(getInnerModel().getTotal());
			}
		}
		
		

		protected String formatCurrencyField(double value, boolean displayCurrency){
			String currencyFilter = (displayCurrency ? "{0} €" : "{0}");
			DecimalFormat formatter = new DecimalFormat("###,###,###.00");
			return MessageFormat.format(currencyFilter, formatter.format(value));
		}
		protected String formatCurrencyField(double value){
			return formatCurrencyField(value, true);
		}
	}

	//VIEW
	public class SampleInvoiceView extends View{
		@Override
		protected String getCSS() {
			return "div{"
					+ "padding: 0.3em"
					+ "border-radius: 25px;"
					+ "}";
		}
		protected XHTMLFragment getHeader() {
			StyleAttribute style = new StyleAttribute(
					"background: LightSeaGreen;"
							+ "padding: 0px 0;"
							+ "font-size: 1.4em;"
							+ "color: white;"
							+ "text-align: left;");
			return new Tag("div", new LinearLayout(getLogoArea(), getHeaderDetailsArea()), new TagAttributes(style));
		}
		protected Div getHeaderDetailsArea() {
			StyleAttribute sqStyle = new StyleAttribute("background: gold;");
			Div location = new Div(new Literal("08251 Santpedor"), new TagAttributes(sqStyle));
			return new Div(new LinearLayout(location), new TagAttributes(new StyleAttribute("float:right;")));
		}
		protected Div getLogoArea() {
			return new Div(new H(1, "TADIPOL"), new TagAttributes(new StyleAttribute("float: left;")));
		}
		protected XHTMLFragment getBody() {
			return new Div(new LinearLayout(getBodyHeader(), getBodyDetails()));
		}
		protected XHTMLFragment getBodyHeader() {
			return new Div("Body header");
		}
		protected XHTMLFragment getBodyDetails() {
			StyleAttribute style = new StyleAttribute(
					"background: lightblue; border-bottom: 1px solid #AAAAAA; padding: 10px 0; margin-bottom: 20px;");
			return new Div(new LinearLayout(new H(2, "Products"), getProductTable()),  new TagAttributes(style));
		}
		protected XHTMLFragment getProductTable() {
			TableFragment table = new TableFragment();
			TableRow header = table.new TableRow();
			
			table.addRow();
			return table;
		}

		protected XHTMLFragment getFooter() {
			StyleAttribute styleAttribute = new StyleAttribute("background-color: lightblue;");
			return new Tag("footer", new Literal("Footer content"), new TagAttributes(styleAttribute));
		}

		@Override
		protected String getXHTML() {
			return new LinearLayout(getHeader(), getBody(), getFooter()).getXHTML();
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
