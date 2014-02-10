/*
 * Copyright 2014 Reginaldas.
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
package lt.eif.viko.wicket.ui;

import com.google.inject.servlet.ServletModule;
import java.util.HashMap;
import java.util.Map;
import org.apache.wicket.protocol.http.WicketFilter;

/**
 *
 * @author Reginaldas
 */
public class WebModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bind(WicketApplication.class).toProvider(WickGuiceAppProvider.class);
          // avoids "Error initializing WicketFilter - you have no <filter-mapping> element..." 
        // IllegalArgumentException
        Map<String, String> params = new HashMap<String, String>();
        params.put(WicketFilter.FILTER_MAPPING_PARAM, "/*");

        filter("/*").through(WicketGuiceFilter.class, params);

    }

}
