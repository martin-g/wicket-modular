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

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import org.apache.wicket.protocol.http.IWebApplicationFactory;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketFilter;

/**
 *
 * @author Reginaldas
 */
@Singleton
class WicketGuiceFilter extends WicketFilter{
    
    @Inject
    private Provider<WicketApplication> appProvider;

    @Override
    protected IWebApplicationFactory getApplicationFactory() {
        return new IWebApplicationFactory() {

            @Override
            public WebApplication createApplication(WicketFilter wf) {
                return appProvider.get();
            }

            @Override
            public void destroy(WicketFilter wf) {
            }
        };
    }
}
