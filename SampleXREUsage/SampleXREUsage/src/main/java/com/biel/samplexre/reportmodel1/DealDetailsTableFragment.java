package com.biel.samplexre.reportmodel1;

import com.biel.xre.generation.XHTMLReportFragment;
import com.biel.xre.generation.xhtml.LinearLayout;
import com.biel.xre.generation.xhtml.Literal;
import com.biel.xre.generation.xhtml.Tag;

public class DealDetailsTableFragment extends XHTMLReportFragment {

	@Override
	public String getXHTML() {
		Tag header = new Tag("tr",
				new LinearLayout(
						new Tag("th", new Literal("Article")), 
						new Tag("th", new Literal("Detalls")), 
						new Tag("th", new Literal("Quantitat")),
						new Tag("th", new Literal("Preu"))
						)
				);
		LinearLayout linearLayout = new LinearLayout(header);
		for(int i = 0; i < 10; i++){
			Tag row =  new Tag("tr",
					new LinearLayout(
							new Tag("td", new Literal("C1-" + i)), 
							new Tag("td", new Literal("C2-" + i)), 
							new Tag("td", new Literal("x" + "C3-" + i)), 
							new Tag("td", new Literal("C4-" + i + "€"))
							)
					);
			linearLayout.add(row);
		}

		Tag table = new Tag("table", linearLayout);
		return table.getXHTML();
	}

}
