package com.biel.samplexre.reportmodel1;

import com.biel.xre.generation.XHTMLReportFragment;
import com.biel.xre.generation.xhtml.Literal;
import com.biel.xre.generation.xhtml.Tag;
import com.biel.xre.generation.xhtml.attributes.StyleAttribute;
import com.biel.xre.generation.xhtml.attributes.TagAttributes;

public class DealHeaderFragment extends XHTMLReportFragment{

	@Override
	public String getXHTML() {
		// TODO Auto-generated method stub
		return new Tag("h1", new Literal("Header"), new TagAttributes(new StyleAttribute("color:red;"))).getXHTML();
	}

}
