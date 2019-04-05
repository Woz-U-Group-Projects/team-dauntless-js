import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// Angular Routing
import { AppRoutingModule } from './app-routing.module';

// Phaser module
import { PhaserModule } from 'phaser-component-library';

// Flexlayout Modules
import { FlexLayoutModule } from '@angular/flex-layout';

// Application Component's
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';

// Authentication components
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';

// Game and Leaderboard components
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { GameComponent } from './game/game.component';

// Application Service's
import { UserService } from './services/user.service';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    LeaderboardComponent,
    GameComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    PhaserModule,
    FlexLayoutModule
  ],
  providers: [ UserService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
