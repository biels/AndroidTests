package com.biel.samplexre.reportmodel1;

import com.biel.xre.generation.ReportFragment;
import com.biel.xre.generation.xhtml.Literal;
import com.biel.xre.generation.xhtml.Tag;

public class DealHeaderFragment extends ReportFragment{

	@Override
	public String getXHTML() {
		// TODO Auto-generated method stub
		return new Tag("h1", new Literal("Header")).getXHTML();
	}

}
