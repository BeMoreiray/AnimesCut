import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedRoutingModule } from './shared-routing.module';
import { NavbarComponent } from './navbar/navbar.component';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    SharedRoutingModule,
    NavbarComponent

  ],
  exports: [NavbarComponent]
})
export class SharedModule { }
