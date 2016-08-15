package com.biel.samplexre.reportmodel1;

import com.biel.xre.generation.XHTMLReportFragment;
import com.biel.xre.generation.xhtml.*;

public class DealDetailsFragment extends XHTMLReportFragment {
	DealDetailsTableFragment ddtf = new DealDetailsTableFragment();
	@Override
	public String getXHTML() {
		// TODO Auto-generated method stub
		Literal header = new Literal("Details header");
		LinearLayout linearLayout = new LinearLayout(new Tag("h2", header), ddtf);
		return linearLayout.getXHTML();
	}

}
