/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.eif.viko.domain;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Module;
import lt.eif.viko.domain.service.IService;
import lt.eif.viko.domain.service.impl.Service;

/**
 *
 * @author Reginaldas
 */
public class ProjectModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(IService.class).to(Service.class);
    }
    
}
