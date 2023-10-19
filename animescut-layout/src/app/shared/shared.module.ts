import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedRoutingModule } from './shared-routing.module';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';



@NgModule({
  declarations: [
    FooterComponent,


  ],
  imports: [
    CommonModule,
    SharedRoutingModule,
    NavbarComponent


  ],
  exports: [NavbarComponent, FooterComponent]
})
export class SharedModule { }
