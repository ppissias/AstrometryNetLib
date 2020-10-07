# Astrometry.net java library
This is a java library for plate solving astronomical images using the http://nova.astrometry.net/ web api

## Usage
```java
		//blind solve
		File file = new File("...");
		Future<PlateSolveResult> solveResult = astrometryLib.blindSolve(file);
		PlateSolveResult result = solveResult.get(); //may take some minutes
		if (result.isSuccess()) {
			System.out.println("Hurrayyy.."+result.getSolveInformation());
		} else {
			System.out.println("Unfortunately astrometry.net could not solve your image");
		}		
		
		//using custom parameters for solving the image
		SubmitFileRequest customSolveParameters = SubmitFileRequest.builder().withPublicly_visible("y").withScale_units("degwidth")
				.withScale_lower(0.1f).withScale_upper(180.0f).withDownsample_factor(2f).withRadius(1.0f).build();
		Future<PlateSolveResult> solveResult = astrometryLib.customSolve(astronomicalFile, customSolveParameters);
		//if the file is a FITS file the OBJCTRA and OBJCTDEC information from the header will be used if not provided in the customSolveParameters object
		//...
```
## Compiling
```
gradlew build -x test
```
and the resulting .jar library can be found in build/libraries
