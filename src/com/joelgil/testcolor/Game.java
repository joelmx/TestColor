package com.joelgil.testcolor;

import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Color;

public class Game extends Activity {

	static TextView textviews[][]; // easier to change backgrounds
	static boolean flags[][];
	Button purpleButton, blueButton, greenButton, yellowButton, redButton, pinkButton;
	static int colorArray[] = new int[6];
	static int tiles[][];

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);

		/*
		 * http://web.njit.edu/~kevin/rgb.txt.html
		 * http://www.shodor.org/stella2java/rgbint.html
		 */
		colorArray[0] = Color.rgb(128, 0, 200); // morado
		colorArray[1] = Color.rgb(80, 180, 255); // azul
		colorArray[2] = Color.rgb(118, 180, 40); // verde
		colorArray[3] = Color.YELLOW;
		colorArray[4] = Color.RED;
		colorArray[5] = Color.MAGENTA;

		/* Find Tablelayout defined in main.xml */
		TableLayout tl = (TableLayout) findViewById(R.id.myTableLayout);
		textviews = new TextView[16][16];
		flags = new boolean[textviews.length][textviews[0].length];
		tiles = new int[textviews.length][textviews.length];

		int size = 320 / textviews.length;

		// crea el grid de twxtviews
		for (int r = 0; r < textviews.length; r++)
			for (int c = 0; c < textviews[0].length; c++) {
				int x = colorArray[(int) (Math.random() * 5.5)];
				textviews[r][c] = new TextView(this);
				textviews[r][c].setBackgroundColor(x);
				textviews[r][c].setTag("");
				textviews[r][c].setHeight(size);
				textviews[r][c].setWidth(size);
				tiles[r][c] = x;
				flags[r][c] = false;
			}

		// inicia las tablerowas
		TableRow tr[] = new TableRow[textviews.length];
		for (int i = 0; i < tr.length; i++)
			tr[i] = new TableRow(this);

		/*
		 * Create a new row to be added. Add Button to row.
		 */
		for (int r = 0; r < textviews.length; r++) {
			/* Create a new row to be added. */
			RelativeLayout.LayoutParams trParam = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
			//params.addRule(verb)
			tr[r].setLayoutParams(trParam);
//			tr[r].generateLayoutParams(new AttributeSet(LayoutParams.FILL_PARENT));
			for (int c = 0; c < textviews[0].length; c++) {
				tr[r].addView(textviews[r][c]);
			}
			tl.addView(tr[r], new TableLayout.LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		}

		purpleButton = (Button) this.findViewById(R.id.b1);
		purpleButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				falsear();
				clicEnBoton(colorArray[0], tiles[0][0], 0, 0);
			}
		});

		blueButton = (Button) this.findViewById(R.id.b2);
		blueButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				falsear();
				clicEnBoton(colorArray[1], tiles[0][0], 0, 0);
			}
		});

		greenButton = (Button) this.findViewById(R.id.b3);
		greenButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				falsear();
				clicEnBoton(colorArray[2], tiles[0][0], 0, 0);
			}
		});

		yellowButton = (Button) this.findViewById(R.id.b4);
		yellowButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				falsear();
				clicEnBoton(colorArray[3], tiles[0][0], 0, 0);
			}
		});

		redButton = (Button) this.findViewById(R.id.b5);
		redButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				falsear();
				clicEnBoton(colorArray[4], tiles[0][0], 0, 0);
			}
		});

		pinkButton = (Button) this.findViewById(R.id.b6);
		pinkButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				falsear();
				clicEnBoton(colorArray[5], tiles[0][0], 0, 0);
			}
		});

	}

	public void clicEnBoton(int sel, int ini, int x, int y) {
		flags[x][y] = true;
		textviews[x][y].setBackgroundColor(sel);
		tiles[x][y] = sel;

		if (x > 0)
			if (tiles[x - 1][y] == ini && !flags[x - 1][y])
				clicEnBoton(sel, ini, x - 1, y);

		if (x < (tiles.length - 1))
			if (tiles[x + 1][y] == ini && !flags[x + 1][y])
				clicEnBoton(sel, ini, x + 1, y);

		if (y > 0)
			if (tiles[x][y - 1] == ini && !flags[x][y - 1])
				clicEnBoton(sel, ini, x, y - 1);

		if (y < (tiles.length - 1))
			if (tiles[x][y + 1] == ini && !flags[x][y + 1])
				clicEnBoton(sel, ini, x, y + 1);

	}

	public void falsear() {
		for (int r = 0; r < flags.length; r++)
			for (int c = 0; c < flags[0].length; c++)
				flags[r][c] = false;
	}
}
