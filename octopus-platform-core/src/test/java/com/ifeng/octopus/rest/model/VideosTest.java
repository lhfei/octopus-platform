/*
 * Copyright 2010-2011 the original author or authors.
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
 

package com.ifeng.octopus.rest.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifeng.octopus.bpm2.test.support.BasicTestSuit;

*//**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Sep 16, 2014
 *//*
public class VideosTest extends BasicTestSuit {

	
	@Test
	public void testModel() {
		VideoModel model = new VideoModel();
		List<Video> videos = new ArrayList<Video>();
		
		model.setStart(0);
		model.setTotal(100);
		model.setVideos(videos);
		
		for(int i=0; i<MAX_ITEM_SIZE; i++){
			Video v = new Video();
			v.setCategory("Category "+i);
			v.setCategoryCod("Category coe "+i);
			v.setCp("CP "+i);
			v.setCpCode("CP code "+i);
			v.setCreateDate("2014-09-0" +i);
			v.setDuration("Duration " +i);
			v.setId(i);
			v.setKeyWords("Key " +i);
			v.setName("Name "+i);
			v.setOriginal("Original "+i);
			v.setProducer("Producer "+i);
			v.setUrl("URL "+i);
			v.setRealPath("RealPath "+i);
			
			videos.add(v);
		}

		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("src\\test\\VideoModel.json"), model);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static final int MAX_ITEM_SIZE = 10;
}
*/