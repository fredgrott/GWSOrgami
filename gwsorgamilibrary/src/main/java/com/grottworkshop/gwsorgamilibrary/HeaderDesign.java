/*
 * Copyright 2015 florent37, Inc.
 * Modifications Copyright 2015 Fred Grott(GrottWorkShop)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.grottworkshop.gwsorgamilibrary;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

/**
 * HeaderDesign class
 * Created by fgrott on 7/7/2015.
 */
public class HeaderDesign {

    protected int color;
    protected int colorRes;
    protected String imageUrl;
    protected Drawable drawable;

    private HeaderDesign() {
    }

    /**
     *
     * @param color the color
     * @param imageUrl the imageUrl
     * @return teh headerDesign
     */
    public static HeaderDesign fromColorAndUrl(@ColorInt int color, String imageUrl) {
        HeaderDesign headerDesign = new HeaderDesign();
        headerDesign.color = color;
        headerDesign.imageUrl = imageUrl;
        return headerDesign;
    }

    /**
     *
     * @param colorRes the colorRes
     * @param imageUrl the imageUrl
     * @return the headerDesign
     */
    public static HeaderDesign fromColorResAndUrl(@ColorRes int colorRes, String imageUrl) {
        HeaderDesign headerDesign = new HeaderDesign();
        headerDesign.colorRes = colorRes;
        headerDesign.imageUrl = imageUrl;
        return headerDesign;
    }

    /**
     *
     * @param color the color
     * @param drawable the drawable
     * @return the headerDesign
     */
    public static HeaderDesign fromColorAndDrawable(@ColorInt int color, Drawable drawable) {
        HeaderDesign headerDesign = new HeaderDesign();
        headerDesign.drawable = drawable;
        headerDesign.color = color;
        return headerDesign;
    }

    /**
     *
     * @param colorRes teh colorRes
     * @param imageUrl the imageUrl
     * @return the headerDesign
     */
    public static HeaderDesign fromColorResAndDrawable(@ColorRes int colorRes, String imageUrl) {
        HeaderDesign headerDesign = new HeaderDesign();
        headerDesign.colorRes = colorRes;
        headerDesign.imageUrl = imageUrl;
        return headerDesign;
    }

    /**
     *
     * @return the color
     */
    public int getColor() {
        return color;
    }

    /**
     *
     * @return the colorRes
     */
    public int getColorRes() {
        return colorRes;
    }

    /**
     *
     * @return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     *
     * @return the drawable
     */
    public Drawable getDrawable() {
        return drawable;
    }

}
