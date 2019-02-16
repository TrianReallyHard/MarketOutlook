/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import com.google.api.services.actions_fulfillment.v2.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.APICaller.callAPI;

/**
 * Implements all intent handlers for this Action. Note that your App must extend from DialogflowApp
 * if using Dialogflow or ActionsSdkApp for ActionsSDK based Actions.
 */
public class Handler extends DialogflowApp {

  private static final Logger LOGGER = LoggerFactory.getLogger(Handler.class);

  @ForIntent("Default Welcome Intent")
  public ActionResponse welcome(ActionRequest request) {
    LOGGER.info("Welcome intent start.");
    ResponseBuilder responseBuilder = getResponseBuilder(request);
    ResourceBundle rb = ResourceBundle.getBundle("resources");
    User user = request.getUser();

    if (user != null && user.getLastSeen() != null) {
      responseBuilder.add(rb.getString("welcome_back"));
    } else {
      responseBuilder.add(rb.getString("welcome"));
    }

    LOGGER.info("Welcome intent end.");
    return responseBuilder.build();
  }

  @ForIntent("bye")
  public ActionResponse bye(ActionRequest request) {
    LOGGER.info("Bye intent start.");
    ResponseBuilder responseBuilder = getResponseBuilder(request);
    ResourceBundle rb = ResourceBundle.getBundle("resources");

    responseBuilder.add(rb.getString("bye")).endConversation();
    LOGGER.info("Bye intent end.");
    return responseBuilder.build();
  }

  @ForIntent("Test")
  public ActionResponse APITest(ActionRequest request) {
    LOGGER.info("API intent start.");
    ResponseBuilder responseBuilder = getResponseBuilder(request);
    ResourceBundle rb = ResourceBundle.getBundle("resources");
    /*String result = "The API call failed.";
    URL link = null;
    try {
      link = new URL("https","api.github.com","/zen/");
      result = callAPI(false, true, link);
      LOGGER.info(result);
    } catch (Exception e) {
      LOGGER.error(e.toString());
      StackTraceElement[] stacktrace = e.getStackTrace();
      for (Object o: stacktrace) {
        LOGGER.error(o.toString());
      }
    }*/

    LOGGER.info("Bye intent end.");
    return responseBuilder.add(result).build();
  }
}