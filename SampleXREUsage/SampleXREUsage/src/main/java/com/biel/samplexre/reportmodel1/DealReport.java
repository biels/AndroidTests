package com.biel.samplexre.reportmodel1;

import com.biel.xre.generation.Report;
import com.biel.xre.generation.xhtml.LinearLayout;

public class DealReport extends Report{
	DealHeaderFragment header = new DealHeaderFragment();
	DealDetailsFragment details = new DealDetailsFragment();
	@Override
	public String getXHTML() {
		// TODO Auto-generated method stub
		return new LinearLayout(header, details).getXHTML();
	}

}
