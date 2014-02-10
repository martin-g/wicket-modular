package lt.eif.viko.wicket.ui;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 *
 * @see lt.eif.viko.mavenproject2.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

    private transient Injector injector;

    public WicketApplication(Injector injector) {
        this.injector = injector;
    }

    /**
     * @return 
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();
        // add your configuration here
        getComponentInstantiationListeners().add(new GuiceComponentInjector(this, injector));
    }
}
