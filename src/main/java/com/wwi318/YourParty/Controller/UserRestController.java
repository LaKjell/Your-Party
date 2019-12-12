package com.wwi318.YourParty.Controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wwi318.YourParty.Entity.User;
import com.wwi318.YourParty.File.UploadFileResponse;
import com.wwi318.YourParty.Service.FileStorageService;
import com.wwi318.YourParty.Service.UserService;

@RestController
public class UserRestController {
	@Autowired
	private UserService userService;

	@Autowired
	private FileStorageService fileStorageService;

	@RequestMapping(method = RequestMethod.GET, value = "/username", produces = MediaType.APPLICATION_JSON_VALUE)
	public User currentUser(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		String username = principal.getName();
		return userService.findByUsername(username);
	}

	@PostMapping("/uploadProfilePicture")
	public UploadFileResponse uploadProfilePicture(@RequestParam("file") MultipartFile file, String username) {

		String fileName = fileStorageService.storePicture(file, username);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile/ProfilePictures/").path(fileName).toUriString();

		return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}

}
