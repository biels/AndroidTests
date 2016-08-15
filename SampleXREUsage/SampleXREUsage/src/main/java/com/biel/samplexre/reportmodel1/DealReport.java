package com.biel.samplexre.reportmodel1;

import com.biel.xre.generation.XHTMLReport;
import com.biel.xre.generation.xhtml.LinearLayout;

public class DealReport extends XHTMLReport{
	DealHeaderFragment header = new DealHeaderFragment();
	DealDetailsFragment details = new DealDetailsFragment();
	@Override
	public String getXHTML() {
		// TODO Auto-generated method stub
		String xhtml = new LinearLayout(header, details).getXHTML();
		return xhtml;
	}

}
