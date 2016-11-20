package by.zhdanovich.pars.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Pattern;
import by.zhdanovich.pars.composition.Component;
import by.zhdanovich.pars.composition.CompositeTool;
import by.zhdanovich.pars.composition.EntityType;

public class Action {
	public static final String REG_EXP = "([I|i]{1}[\\w]{1})";

	public Component sortSentanceByQuantity(CompositeTool wholeText) {
		Component buffer = new CompositeTool(EntityType.SENTANCE);
		for (Component paragraph : wholeText.getList()) {
			buffer.getList().addAll(paragraph.getList());
		}
		Collections.sort(buffer.getList(), new Comparator<Component>() {
			@Override
			public int compare(Component o1, Component o2) {
				if (o1.getList().size() > o2.getList().size())
					return 1;
				if (o1.getList().size() < o2.getList().size())
					return -1;
				else
					return 0;
			}
		});
		return buffer;
	}

	public void changeOfPlace(CompositeTool wholeText) {
		Component buffer1 = new CompositeTool(EntityType.LEXEMA);
		Component buffer2 = new CompositeTool(EntityType.LEXEMA);
		for (Component paragraph : wholeText.getList()) {
			for (Component sentance : paragraph.getList()) {
				buffer1 = sentance.getList().get(0);
				buffer2 = sentance.getList().get(sentance.getList().size() - 1);
				sentance.getList().remove(0);
				sentance.getList().add(0, buffer2);
				int i = sentance.getList().size();
				sentance.getList().remove(i - 1);
				sentance.getList().add((i - 1), buffer1);
			}
		}
	}

	public void deleteLexeme(CompositeTool wholeText) {
		for (Component paragraph : wholeText.getList()) {
			for (Component sentance : paragraph.getList()) {
				amount(sentance);
			}
		}
	}

	private void amount(Component lexeme) {
		for (int i = 0; i < lexeme.getList().size();) {
			if (!Pattern.matches(REG_EXP, lexeme.getList().get(i).toString())) {
				i++;
			} else {
				lexeme.getList().remove(i);
			}

		}
	}
}
