# Java Angular 2 application utilizing the GWT compiler

Angular 2 has been wrapped around Typescript and Dart because those languages offer code generation (for component metadata).

Java has the standard Java JSR-269...

So this project is a try to integrate Angular 2 and Java via the GWT compiler in a way that is pleasant for the developper.

## Demo

A demo is available [here](http://lteconsulting.fr/angular2-gwt/).

## Instructions

Checkout this repo, then :

		mvn clean install
		cd angular2-gwt-sample
		mvn gwt:run (or mvn jetty:run-war)

Go to your browser and it should work !

When loading the source in eclipse, don't forget to enable code generation on the angular2-gwt-sample project!


## Explanation

The main application is in the `Application` class and is bootstrapped in the Angular sense with this line of code :

		Browser.bootstrap( MyComponent_AngularComponent.get() );

Here, the `MyComponent` class, written by us, is used as an Angular component. The `MyComponent_AngularComponent` is a Java generated class embedding all the required metadatas for the Angular runtime.

And the component is implemented in the `MyComponent` class, which reads :

		@AngularComponent(
				selector = "my-app",
				template = "<div>"
						+ "Name of hero to add : {{name}}<br/>"
						+ "<input [(ngModel)]='name'><br/>"
						+ "<button (click)='onClick($event)'>Add</button>"
						+ "<ul><li *ngFor='#hero of heroes'>{{ hero }}</li></ul>"
						+ "</div>" )
		@JsType
		public class MyComponent
		{
			@JsProperty
			private String name;
		
			@JsProperty
			private JsArray<String> heroes;
		
			public MyComponent()
			{
				name = "Arnaud";
				heroes = JsArray.of( new String[] { "Windstorm", "Bombasto", "Magneta", "Tornado" } );
			}
		
			@JsMethod
			private void onClick()
			{
				heroes.push( name );
			}
		}

This is quiet straight-forward, and the class in the code contains comments so that you can understand everything that is going on...
