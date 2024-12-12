import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ej01',
  templateUrl: './ej01.component.html',
  styleUrls: ['./ej01.component.css']
})
export class Ej01Component implements OnInit {
  numbers : Array<Number> = [1,2,3,4,5];
  varColor : boolean = true;

  customers = [{value: 'Ebony'}, {value: 'Chiho'}];
  customer = 'Padma';

  constructor() { }

  ngOnInit(): void {
  }

  changeColor() {
    this.varColor = !this.varColor;
    
  }

  onKeydown(event: any){
    // console.log(event);
    console.log((event as KeyboardEvent).key);
    if((event as KeyboardEvent).key == "Delete"){
      console.clear();
    }
  }

}

