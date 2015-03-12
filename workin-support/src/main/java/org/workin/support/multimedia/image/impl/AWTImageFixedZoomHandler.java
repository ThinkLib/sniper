/*
 * Copyright 2015 the original author or authors.
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
 * 
 * Create Date : 2015-1-15
 */

package org.workin.support.multimedia.image.impl;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.workin.support.multimedia.image.AbstractAWTImageZoomHandler;

/**
 * @description AWT图像固定缩放处理器实现类
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public class AWTImageFixedZoomHandler extends AbstractAWTImageZoomHandler {

	protected BufferedImage drawHandle(InputStream source) throws IOException {
		BufferedImage imageSource = ImageIO.read(source); 
		// 目标图片对象
		BufferedImage destImage = new BufferedImage(minWidth, minHeight, imageSource.getType());
		Graphics g = destImage.getGraphics();
		g.drawImage(imageSource, 0, 0, minWidth, minHeight, null);
		return destImage;
	}
	
}
