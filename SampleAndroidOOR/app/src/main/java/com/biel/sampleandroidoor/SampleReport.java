package com.biel.sampleandroidoor;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.biel.oor.Report;
import com.biel.xre.generation.TableFragment;
import com.biel.xre.generation.XHTMLFragment;
import com.biel.xre.generation.xhtml.LinearLayout;
import com.biel.xre.generation.xhtml.Literal;
import com.biel.xre.generation.xhtml.Tag;
import com.biel.xre.generation.xhtml.attributes.StyleAttribute;
import com.biel.xre.generation.xhtml.attributes.TagAttributes;
import com.biel.xre.generation.xhtml.tags.Div;
import com.biel.xre.generation.xhtml.tags.H;

import java8.util.function.Consumer;
import java8.util.function.Function;
import java8.util.function.ToDoubleFunction;
import java8.util.function.UnaryOperator;
import java8.util.stream.Collectors;
import java8.util.stream.IntStream;
import java8.util.stream.RefStreams;
import java8.util.stream.StreamSupport;


/**
 * Created by Biel on 1/8/2016.
 */
public class SampleReport extends Report {
    //MODEL
    public class SampleInvoiceModel extends Model{
        public CompanyInfo companyInfo = new CompanyInfo();
        public ContactInfo contactInfo = new ContactInfo();
        public ProductList productList = new ProductList();
        //To override inner classes, override in the constructor
        public class CompanyInfo {
            public String name;
            public String slogan;
            public String city;
            public String address;
            public String zip;
            public String phone;

        }
        public class ContactInfo {
            public String name;
            public String phone;
            public String email;

        }
        public class ProductInfo{
            public String name;
            public String description;
            public double price;
            public int amount;
            //Support for nested products
            public List<ProductInfo> products = new ArrayList<ProductInfo>();

            //Edit getters to match view's needs. Add getters for priceBeforeDiscount...
            //Maybe merge product and productrequest into InvoiceProduct


        }
        public class ProductList{
            private List<ProductInfo> productList = new ArrayList<>();
            //Discounts, taxes, etc.
            public List<ProductInfo> getList() {
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
    public class SampleInvoiceController extends com.biel.oor.Report.Controller{
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
            public List<ProductTableRow> getRows(){
                //return StreamSupport.intStream(0, getInnerModel().getList().size()).mapToObj(i -> new ProductTableRow(i)).collect(Collectors.toList());
                return RefStreams.iterate(0, new UnaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer i) {
                        return i + 1;
                    }
                }).limit(getInnerModel().getList().size()).map(new Function<Object, Integer>() {
                    @Override
                    public Integer apply(Object o) {
                        return (Integer)o;
                    }
                }).map(new Function<Integer, ProductTableRow>() {
                    @Override
                    public ProductTableRow apply(Integer i) {
                        return new ProductTableRow(i);
                    }
                }).collect(Collectors.<ProductTableRow>toList());
            }
            private double calculateGrandTotal(){
                return StreamSupport.stream(getInnerModel().getList()).mapToDouble(new ToDoubleFunction<SampleInvoiceModel.ProductInfo>() {
                    @Override
                    public double applyAsDouble(SampleInvoiceModel.ProductInfo p) {
                        return p.price * p.amount;
                    }
                }).sum();
            }
            public String getGrandTotal(){
                return formatCurrencyField(calculateGrandTotal());
            }
        }
        public ProductTable getProductTable(){
            return new ProductTable();
        }
        /**
         * Provides the necessary information to generate a specific row from the product table, reperesenting a product
         */
        public class ProductTableRow{
            private int index;
            double total = 0.0;
            public ProductTableRow(int index) {
                this.index = index;
            }
            public SampleInvoiceModel.ProductInfo getInnerModel() {
                return getModel().getProductList().getList().get(index);
            }
            public double calculateTotal(){ //Directly calculated fields are part of the model
                return getInnerModel().price * getInnerModel().amount;
            }
            public String getPrice(){
                return formatCurrencyField(getInnerModel().price);
            }
            public String getTotal(){
                return formatCurrencyField(calculateTotal());
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
                    + "padding: 8px"
                    + "}"
                    + "th, td {\r\n" +
                    "    padding: 8px;\r\n" +
                    "    text-align: left;\r\n" +
                    "    border-bottom: 1px solid #ddd;\r\n" +
                    "}"
                    + "table {\r\n" +
                    "    border-collapse: collapse;\r\n" +
                    "    width: 100%;\r\n" +
                    "}";
        }
        protected XHTMLFragment getHeader() {
            StyleAttribute style = new StyleAttribute(
                    "background: #407F7F;"
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
            return new Div(new LinearLayout(getBodyHeader(), getBodyDetails()), new StyleAttribute("background: lightyellow;"));
        }
        protected XHTMLFragment getBodyHeader() {
            return new Div("Company info");
        }
        protected XHTMLFragment getBodyDetails() {
            StyleAttribute style = new StyleAttribute(
                    "background: lightblue; border-bottom: 1px solid #AAAAAA; padding: 10px 0; margin-bottom: 20px;");
            return new Div(new LinearLayout(new H(2, new Literal("Products"), new StyleAttribute("padding: right 8px;")), getProductTable(), getBodyDetailsSummary()),  new TagAttributes(style));
        }
        protected Div getBodyDetailsSummary() {
            StyleAttribute style = new StyleAttribute("background-color: #ffcc00; text-align: right; padding: 1px; width: 100%; display: inline-block; float: right;");
            StyleAttribute totalStyle = new StyleAttribute("margin-right: 0");
            Div total = new Div(new Literal("Total: " + getController().getProductTable().getGrandTotal()));
            return new Div(total, new TagAttributes(style));
        }
        protected XHTMLFragment getProductTable() {
            final TableFragment table = new TableFragment();
            table.addRow(RefStreams.of("Product", "Description", "Unit price", "Amount", "Total").map(new Function<String, Literal>() {
                @Override
                public Literal apply(String s) {
                    return new Literal(s);
                }
            }).collect(Collectors.<XHTMLFragment>toList()));
            Consumer<? super SampleInvoiceController.ProductTableRow> consumer = new Consumer<SampleInvoiceController.ProductTableRow>() {
                @Override
                public void accept(SampleInvoiceController.ProductTableRow r) {
                    table.addRow(
                            new Literal(r.getInnerModel().name),
                            new Literal(r.getInnerModel().description),
                            new Literal(r.getPrice()),
                            new Literal(r.getInnerModel().amount),
                            new Literal(r.getTotal())
                    );
                }
            };
            StreamSupport.stream(getController().getProductTable().getRows()).forEach(consumer);
            return table;
        }

        protected XHTMLFragment getFooter() {
            StyleAttribute styleAttribute = new StyleAttribute("background-color: #AA3939; bottom: 0;");
            return new Tag("div", new Literal("Footer content"), new TagAttributes(styleAttribute));
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
