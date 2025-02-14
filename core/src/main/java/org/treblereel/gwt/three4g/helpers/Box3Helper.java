package org.treblereel.gwt.three4g.helpers;

import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.math.Box3;
import org.treblereel.gwt.three4g.math.Color;
import org.treblereel.gwt.three4g.objects.LineSegments;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 5/4/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class Box3Helper extends LineSegments {

    /**
     * The Box3 being visualized.
     */
    public Box3 box;

    /**
     * Creates a new wireframe box that represents the passed Box3.
     *
     * @param box -- the Box3 to show.
     */
    public Box3Helper(Box3 box) {

    }

    /**
     * Creates a new wireframe box that represents the passed Box3.
     *
     * @param box   -- the Box3 to show.
     * @param color -- the box's color. Default is 0xffff00.
     */
    public Box3Helper(Box3 box, Color color) {

    }

    /**
     * Return a copy of this ArrowHelper.
     *
     * @param source instance of Box3Helper
     * @return instance of Box3Helper
     */
    public native Box3Helper copy(Box3Helper source);

    /**
     * Return a copy of this Box3Helper.
     *
     * @return instance of Box3Helper
     */
    public native Box3Helper clone();

    /**
     * This overrides the method in the base Object3D class so that it also updates the wireframe box to the extent of the .box property.
     */
    public native void updateMatrixWorld(boolean force);
}
