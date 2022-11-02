package com.gdu.app05.service;

import org.springframework.http.ResponseEntity;

public interface GalleryService {

	public ResponseEntity<byte[]> imageDisplay(String path, String filename);
}
