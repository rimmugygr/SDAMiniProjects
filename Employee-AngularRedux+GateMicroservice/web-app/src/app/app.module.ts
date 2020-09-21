
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import {AppRoutingModule} from './app-routing.module';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {NgxsModule} from '@ngxs/store';
import {environment} from '../environments/environment';
import {StateClass} from '@ngxs/store/internals';
import {NgxsStoragePluginModule, StorageOption} from '@ngxs/storage-plugin';
import {NgxsReduxDevtoolsPluginModule} from '@ngxs/devtools-plugin';
import {EmployeesState} from './shared/state/employees/employees.state';
import {NgxMaskModule} from 'ngx-mask';

const persistentStates: StateClass<any>[] = [EmployeesState];
const states: StateClass<any>[] = [...persistentStates];

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent
  ],
    imports: [
      BrowserModule,
      AppRoutingModule,
      HttpClientModule,
      NgxMaskModule.forRoot(),
      NgxsModule.forRoot(states, {developmentMode: !environment.production}),
      NgxsStoragePluginModule.forRoot({ key: persistentStates, storage: StorageOption.LocalStorage}),
      NgxsReduxDevtoolsPluginModule.forRoot({disabled: environment.production})
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
