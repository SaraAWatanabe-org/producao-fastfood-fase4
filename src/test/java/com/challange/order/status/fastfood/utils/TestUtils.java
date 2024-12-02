package com.challange.order.status.fastfood.utils;

import com.challange.order.status.fastfood.controller.request.LunchRequest;
import com.challange.order.status.fastfood.model.Lunch;

import java.net.http.HttpResponse;

public class TestUtils {

	public static Lunch buildLunchMock() {
		return EasyRandomUtils.nextObject(Lunch.class);
	}

	public static LunchRequest buildLunchRequesthMock() {
		return EasyRandomUtils.nextObject(LunchRequest.class);
	}

	public static HttpResponse<String> buildHttpClientResponse(){
		return EasyRandomUtils.nextObject(HttpResponse.class);
	}
}
