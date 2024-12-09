import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { Ej01Component } from './ej01/ej01.component';

@NgModule({
  declarations: [
    AppComponent,
    Ej01Component
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [Ej01Component]
})
export class AppModule { }
