# Weather-Alerts

This Weather Alerts app uses the clean architecture https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html in combination with MVVM for the presentation layer. 
The app uses kotlin flow and live data for handling the data flow between the data, domain and presentation layers. 
For Dependency Injection the app makes use of Hilt: https://developer.android.com/training/dependency-injection/hilt-android

![image](https://github.com/karel-vdm/Weather-Alerts/assets/80144326/393858bf-52eb-49e3-bdcc-71eccebffba1)

The clean architecture pattern enforces dependency inversion by not allowing high-level modules to depend on low-level modules. They depend on abstractions instead.

More on the diffrent layers defined in clean archtecture:

Data layer: The data layer is a one to one mapping of the api. There should be no business or display logic in the data layer. The data layer is purely responseble for getting data from the defined data source.

Domain layer: The domain layer is responsible for busniss logic as well as any changes to the api defined object structures. To satisfy dependency inversion we map the data layer object to a domain layer object. The data layer should not know about any low level domain layer objects.

Presentation layer: The presentation layer is responsible for handling the display of data as well as view rendering logic. The domain layer object is mapped to a presentation layer object (ViewModel). Any changes to data for display purposes should be handled in the presentation layer.

![image](https://github.com/karel-vdm/Weather-Alerts/assets/80144326/3d24dccd-4b41-445b-bdd9-e8b2c01ac9b0)
