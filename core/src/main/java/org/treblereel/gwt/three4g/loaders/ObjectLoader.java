package org.treblereel.gwt.three4g.loaders;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.three4g.core.Object3D;
import org.treblereel.gwt.three4g.core.PropertyHolder;
import org.treblereel.gwt.three4g.loaders.managers.LoadingManager;
import org.treblereel.gwt.three4g.textures.Texture;

/**
 * A loader for loading a JSON resource. Unlike the JSONLoader, this one make use of the .type attributes of objects to map them to their original classes.
 * <p>
 * Note that this loader can't load Geometries. Use JSONLoader instead for that.
 * <p>
 * This uses the FileLoader internally for loading files.
 * <p>
 * var loader = new THREE.ObjectLoader();
 * <p>
 * loader.load(
 * // resource URL
 * "models/json/example.json",
 * <p>
 * // onLoad callback
 * // Here the loaded data is assumed to be an object
 * function ( obj ) {
 * // Add the loaded object to the scene
 * scene.add( obj );
 * },
 * <p>
 * // onProgress callback
 * function ( xhr ) {
 * console.log( (xhr.loaded / xhr.total * 100) + '% loaded' );
 * },
 * <p>
 * // onError callback
 * function ( err ) {
 * console.error( 'An error happened' );
 * }
 * );
 * <p>
 * // Alternatively, to parse a previously loaded JSON structure
 * var object = loader.parse( a_json_object );
 * <p>
 * scene.add( object );
 *
 * @author Dmitrii Tikhomirov
 * Created by treblereel on 3/12/18.
 */
@JsType(isNative = true, namespace = "THREE")
public class ObjectLoader {

    /**
     * If set, assigns the crossOrigin attribute of the image to the value of crossOrigin, prior to starting the load. Default is undefined.
     */
    public String crossOrigin;

    /**
     * The loadingManager the loader is using. Default is DefaultLoadingManager.
     */
    public LoadingManager manager;

    /**
     * The base path or URL from which additional resources like textuures will be loaded. See .setResourcePath. Default is the empty string.
     */
    public String resourcePath;

    @JsConstructor
    public ObjectLoader() {

    }

    /**
     * Creates a new ObjectLoader.
     *
     * @param manager — The loadingManager for the loader to use. Default is THREE.DefaultLoadingManager.
     */
    @JsConstructor
    public ObjectLoader(LoadingManager manager) {

    }

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url    — the path or URL to the file. This can also be a Data URI.
     * @param onLoad — Will be called when load completes. The argument will be the loaded object.
     * @return instance of Texture
     */
    public native Texture load(String url, OnLoadCallback<? extends PropertyHolder> onLoad);

    /**
     * Begin loading from url and call onLoad with the parsed response content.
     *
     * @param url        — the path or URL to the file. This can also be a Data URI.
     * @param onLoad     — Will be called when load completes. The argument will be the loaded object.
     * @param onProgress — Will be called while load progresses. The argument will be the XMLHttpRequest instance, which contains .total and .loaded bytes.
     * @param onError    — Will be called when load errors.
     * @return instance of Texture
     */
    public native Texture load(String url, OnLoadCallback<? extends PropertyHolder> onLoad, OnProgressCallback onProgress, OnErrorCallback onError);

    /**
     * @param json — required. The JSON source to parse.
     *             Parse a JSON structure and return a threejs object. This is used internally by .load, but can also be used directly
     *             to parse a previously loaded JSON structure.
     * @return Object3D
     */
    public native Object3D parse(Object json);

    /**
     * @param json   — required. The JSON source to parse.
     * @param onLoad — Will be called when parsed completes. The argument will be the parsed object.
     *               Parse a JSON structure and return a threejs object. This is used internally by .load, but can also be used directly
     *               to parse a previously loaded JSON structure.
     * @return Object3D
     */
    public native Object3D parse(Object json, OnLoadCallback<? extends PropertyHolder> onLoad);

    /**
     * This is used .parse to parse any geometries or buffer geometries in the JSON structure. Internally it uses JSONLoader
     * for geometries and BufferGeometryLoader for buffer geometries.
     *
     * @param json — required. The JSON source to parse.
     * @return instance of Object3D
     */
    public native Object3D parseGeometries(Object json);

    /**
     * This is used .parse to parse any materials in the JSON structure using MaterialLoader.
     *
     * @param json — required. The JSON source to parse.
     * @return instance of Object3D
     */
    public native Object3D parseMaterials(Object json);

    /**
     * This is used .parse to parse any animations in the JSON structure, using AnimationClip.parse.
     *
     * @param json — required. The JSON source to parse.
     * @return instance of Object3D
     */
    public native Object3D parseAnimations(Object json);

    /**
     * This is used .parse to parse any images in the JSON structure, using ImageLoader.
     *
     * @param json — required. The JSON source to parse.
     * @return instance of Object3D
     */
    public native Object3D parseImages(Object json);

    /**
     * This is used .parse to parse any textures in the JSON structure.
     *
     * @param json — required. The JSON source to parse.
     * @return instance of Object3D
     */
    public native Object3D parseTextures(Object json);

    /**
     * This is used .parse to parse any objects in the JSON structure. Objects can be of the following types:
     * Scene
     * PerspectiveCamera
     * OrthographicCamera
     * AmbientLight
     * DirectionalLight
     * PointLight
     * SpotLight
     * HemisphereLight
     * Mesh
     * LOD
     * Line
     * LineSegments
     * Points
     * Sprite
     * Group
     * Object3D
     *
     * @param json — required. The JSON source to parse.
     * @return instance of Object3D
     */
    public native Object3D parseObject(Object json);

    /**
     * @param value — The crossOrigin string to implement CORS for loading the url from a different domain that allows CORS.
     * @return instance of ObjectLoader
     */
    public native ObjectLoader setCrossOrigin(String value);

    /**
     * Set the base path for the original file.
     *
     * @param path — Base path of the file to load.
     * @return instance of MaterialLoader
     */
    public native ObjectLoader setPath(String path);

    /**
     * Set the base path for dependent resources like textures.
     *
     * @param value — The base path or URL from which resources will be loaded.
     * @return instance of ObjectLoader
     */
    public native ObjectLoader setResourcePath(String value);

}
