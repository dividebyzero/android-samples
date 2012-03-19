package cc.dividebyzero.android.samples.ctxthemes;

/* 
 * Copyright (C) 2012 Ronan 'zero' schwarz [zero AT dividebyzero DOT cc]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */




import cc.dividebyzero.android.samples.ctxthemes.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class CTXThemeExplorerActivity extends Activity {
    /**
     * Demonstrate how to easily switch themes in views by creating specialized
     * context instances. based on my "context is magic" talk.
     * 
     * like this ? donate to nubreaks.com so there's still some good music to
     * code with in the future.
     */

    // some random animals in a list.
    private static String[] listData = {
                                     "Duck",
                                     "Chicken",
                                     "Cat",
                                     "Dog",
                                     "Rat",
                                     "Mouse",
                                     "Fish",
                                     "Fox" // why the fox? don't ask.
                                     };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // load a very simple layout with two listviews
        setContentView(R.layout.main);

        // create a context based on the AppContext with theme set to the
        // android "light" theme
        Context lightContext = new ContextThemeWrapper(getApplicationContext(),android.R.style.Theme_Light);
        // create a context based on the AppContext with theme set to the
        // android "dark" theme
        Context darkContext = new ContextThemeWrapper(getApplicationContext(),android.R.style.Theme_Black);
        // re-use of listadapter variable save some tiny bits of memory. :-)
        ListAdapter la;

        // new adapter with the "light" context
        la = new ArrayAdapter<String>(lightContext,android.R.layout.test_list_item,listData);
        ((ListView) findViewById(R.id.lv1)).setAdapter(la);

        // new adapter with the "dark" context
        la = new ArrayAdapter<String>(darkContext,android.R.layout.test_list_item,listData);
        ((ListView) findViewById(R.id.lv2)).setAdapter(la);


    }





}