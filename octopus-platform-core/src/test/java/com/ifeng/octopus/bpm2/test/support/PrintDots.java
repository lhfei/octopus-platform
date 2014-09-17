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
 */

package com.ifeng.octopus.bpm2.test.support;

import java.util.Map;

import org.jbpm.api.activity.ActivityExecution;
import org.jbpm.api.activity.ExternalActivityBehaviour;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Sep 4, 2014
 */
public class PrintDots implements ExternalActivityBehaviour {

	  private static final long serialVersionUID = 1L;
	  private static final String NEWLINE = System.getProperty("line.separator");

	  public void execute(ActivityExecution execution) {
	    String executionId = execution.getId();
	    
	    String dots = 
	      "                              "+".::::.                    " + NEWLINE +
	      "     " +"                " +"       .:::::" +":::.                  " + 
	      NEWLINE + "                            :::::::::::                 " + NEWLINE +
	      "           " + "                 ':::::::::::..              " 
	      + NEWLINE +"                             ::::" +":::::::::::'           " + NEWLINE +"                              ':::::::::::.             " + NEWLINE +
	      "                                .::::::::" +"::::::'        " + NEWLINE +"                              " +".:::::::::::...           " + NEWLINE +
	      "                             ::::::::::::::''" + 
	      "           " + NEWLINE +"                 .:::.       '::::::::''::::            " + NEWLINE + 
	      "               .::::::::.  " +
	      "    ':::::'  '::::           " + NEWLINE +"              " 
	      +".::::':::::::.   " +" :::::    '::::.         " + NEWLINE +"            .:::::' '::::" 
	      +":::::. :::::      ':::.        " + NEWLINE +"          .:::::'     ':::::::::.:::::   " +"    '::.       " + 
	      NEWLINE +"        .::::''         '::::::::::::::       '::.      " + NEWLINE +"       .::''              ':::::" 
	      +":::::::         :::...  " + NEWLINE +"    ..::::                  ':::::::::'     " +
	      "   .:' '''' " + NEWLINE +" ..''''':'                    ':::::.'                  " + NEWLINE;

	    System.out.println(dots);
	    
	    execution.waitForSignal();
	  }

	  public void signal(ActivityExecution execution, 
	                     String signalName, 
	                     Map<String, ?> parameters) {
	    execution.take(signalName);
	  }
	}

