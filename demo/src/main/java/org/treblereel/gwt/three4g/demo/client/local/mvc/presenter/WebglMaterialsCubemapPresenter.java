package org.treblereel.gwt.three4g.demo.client.local.mvc.presenter;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.treblereel.gwt.three4g.demo.client.local.Attachable;
import org.treblereel.gwt.three4g.demo.client.local.examples.material.WebglMaterialsCubemap;

/**
 * @author Dmitrii Tikhomirov <chani@me.com>
 * Created by treblereel on 7/30/18.
 */
public class WebglMaterialsCubemapPresenter implements Presenter {
    @Override
    public void dispatch(HTMLDivElement container) {
        container.appendChild(((Attachable) GWT.create(WebglMaterialsCubemap.class)).asWidget());
    }
}
